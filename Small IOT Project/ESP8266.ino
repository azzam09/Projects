// the following codes are for NodeMCU ESP8266 (WiFi device) ...

// required libararies:
#include <ESP8266WiFi.h>          //to connect esp8266 with an internet (WiFi)
#include <PubSubClient.h>         //I think, to connect with a client generally
#include <WiFiClientSecure.h>     //I think, to connect with a client safely (using certificants and others)
#include "secrets.h"              //it's a file that contains the secured-connection data of the Client (cloud) like certificants
//NOTE: to include a file, I think you have to use double qoatatoin symbol "" instead of <> symbol
#include <time.h>                 //to handle with time (get current time)
#include <SoftwareSerial.h>       //connect devices using Rx & Tx
#include <ArduinoJson.h>          //to store data in better form (by using json)


//instances & variables:
SoftwareSerial nodemcu(D6, D5);   //D6=Rx & D5=Tx

float h ;
float t;
unsigned long lastMillis = 0;
unsigned long previousMillis = 0;
const long interval = 5000;

//some configurations for esp8266 with AWS cloud:
#define AWS_IOT_PUBLISH_TOPIC   "esp8266/pub"
#define AWS_IOT_SUBSCRIBE_TOPIC "esp8266/sub"
 
WiFiClientSecure net;
 
BearSSL::X509List cert(cacert);
BearSSL::X509List client_crt(client_cert);
BearSSL::PrivateKey key(privkey);
//NOTE: client_cert is inside "sercets" tab (folder) there + and also some other variables
 
PubSubClient client(net);
 
time_t now;
time_t nowish = 1510592825;   //these vairable for what?
 
 
void NTPConnect(void)
{
  Serial.print("Setting time using SNTP");
  configTime(TIME_ZONE * 3600, 0 * 3600, "pool.ntp.org", "time.nist.gov");
  
  now = time(nullptr);
  
  while (now < nowish){
    delay(500);
    Serial.print(".");
    now = time(nullptr);
  }
  Serial.println("done!");

  struct tm timeinfo;
  gmtime_r(&now, &timeinfo);
  Serial.print("Current time: ");
  Serial.print(asctime(&timeinfo));
}
 
 
void messageReceived(char *topic, byte *payload, unsigned int length)
{
  Serial.print("Received [");
  Serial.print(topic);
  Serial.print("]: ");
  for (int i = 0; i < length; i++){
    Serial.print((char)payload[i]);
  }
  Serial.println();
}
 
 
void connectAWS()
{  
  delay(3000);
  WiFi.mode(WIFI_STA);
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
 
  Serial.println(String("Attempting to connect to SSID: ") + String(WIFI_SSID));
 
  while (WiFi.status() != WL_CONNECTED){
    Serial.print(".");
    delay(1000);
  }
 
  NTPConnect();
 
  net.setTrustAnchors(&cert);
  net.setClientRSACert(&client_crt, &key);
 
  client.setServer(MQTT_HOST, 8883);
  client.setCallback(messageReceived);
 
 
  Serial.println("Connecting to AWS IOT");
 
  while (!client.connect(THINGNAME)){
    Serial.print(".");
    delay(1000);
  }
 
  if (!client.connected()) {
    Serial.println("AWS IoT Timeout!");
    return;
  }
  // Subscribe to a topic
  client.subscribe(AWS_IOT_SUBSCRIBE_TOPIC);
 
  Serial.println("AWS IoT Connected!");
}
 
 
//here where we receive then upload the data
//NOTE: this function what actually shown on the cloud and other serial instructions are for serial monitor
void publishMessage()
{
   StaticJsonBuffer<200> buffer;
  JsonVariant data = buffer.parse(nodemcu);   
  data["time"] = millis();
  data["humidity"] = h;  //modification task: change "h" value from "loop" function 
  data["temperature"] = t; //change from loop function
  //JsonArray& jsonBuffer = buffer.parseArray(data);
  char cjson [512];
  data.printTo(cjson);
  //serializeJson(doc, jsonBuffer); // print to client
  //data.printTo(jsonBuffer);
  buffer.clear();

  client.publish(AWS_IOT_PUBLISH_TOPIC, cjson);
  //Question: can we use "doc" variable directly (json variable) instead of a varibale has char-Array type?
  //maybe AWS don't accept to receiving a json data
}
 
/* 
 above codes are user-defined functions (our customized functions)
 =========================================================================
 below is our main program code
*/

void setup()
{
  Serial.begin(9600);
  nodemcu.begin(9600);
  connectAWS();
  
}//End setup
 
 
void loop()
{

  now = time(nullptr);
 
  if (!client.connected()){
    connectAWS();
  }
  else{
    client.loop();
    //me: The alternative if-statement
    if (millis() - lastMillis > 5000)
    {      
      // receiving data from Rx & Tx ports (nodemcu object)
       StaticJsonBuffer<200> buffer;
       JsonVariant data = buffer.parse(nodemcu);
     // DeserializationError error = deserializeJson(doc, nodemcu); //move data from "nodemcu" into "doc"
     

      // Test parsing
      while(!data.success()){
      Serial.println("Invalid Json Object!!");
      Serial.println(F("Failed to read from Arduino to esp8266 !"));
      delay(500);// was 500
     // error = deserializeJson(doc, nodemcu);    //keep deserializing until it's done well
      buffer.clear();
     data = buffer.parse(nodemcu);
     //data.prettyPrintTo(nodemcu); 
      }//End while

      //update h & t values (humidity and temperature) that used in esp8266 (inside this sketch):
      h = data["humidity"];
      t = data["temperature"]; 
      
      lastMillis = millis();
      publishMessage();     //uplaod the data to the client (AWS cloud)
    }
  }//End if-else statement of "client is not connected"
  
}//End loop function