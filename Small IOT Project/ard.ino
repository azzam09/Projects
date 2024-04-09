// Arduino code ...

//required libraries:
#include <DHT.h>                //DHT11 library
#include <SoftwareSerial.h>     //Arduino to NodeMCU libraries

//Initialize Arduino to NodeMCU (5=Rx & 6=Tx)
SoftwareSerial arduino(5,6);    //use pins 5 & 6 in arduino

//Initialization of DHT11 sensor
#define DHTPIN 2
#define DHTTYPE DHT11

//instance + Variables
DHT sensor(DHTPIN, DHTTYPE);
float temp;
float hum;


//main Arduino code starts from here ...
void setup(){
  Serial.begin(9600);  //baud speed for seiral port (Serial communication with computer)
  sensor.begin();
  arduino.begin(9600);
  delay(2000);

  Serial.println("Program is running ...");
}//End setup


void loop(){
  //Obtain Humditiy and Temperature data
  dht_func();

  //send data directly through SoftwareSerial object (arduino)
  arduino.print(hum);
  arduino.println("\n");
  arduino.print(temp);
  arduino.println("\n");
  delay(5000);

}//End mian loop func

//=======================================================
//user-define (our) functions
void dht_func(){
  hum = sensor.readHumidity();
  temp = sensor.readTemperature();  //in Celsius

  // Check if reading failed to exit early (to try again).
  if (isnan(hum) || isnan(temp) )
  {
    Serial.println("Failed to read from DHT sensor!");
    return;
  }

  //show data on Serial monitor
  Serial.print("Humidity (%):  ");
  Serial.print(hum);
  Serial.println("%");
  Serial.print("Temperature (C):  ");
  Serial.print(temp);
  Serial.println("°C");
  //add fehrenhite in the future  
}