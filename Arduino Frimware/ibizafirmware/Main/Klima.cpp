#include "Klima.h"

void Klima::init() {
  Serial.begin(9600);
  Serial1.begin(9600);
  pinMode(climaPin, INPUT_PULLUP);

}
bool Klima::getConectionStatus() {

  return conected;
}
int Klima::getBuferState() {
  return state;
}
int Klima::getBuferFan() {
  return fan;
}
int Klima::getBuferTemp() {
  return temp;
}
void Klima::setState(int reciverBufer[]) {
  fan = reciverBufer[2];
  state = reciverBufer[0];
  temp = reciverBufer[1];


}
void Klima::setConectionStatus(bool st) {
  conected = st;
}

void Klima::flushSerialBufer() {
  for (int i = 0; i < 5; i++) {
    reciverBufer[i] = 0;
  }
}

void Klima::runSystem() {
  if (Serial1.available() > 0) {
   setConectionStatus(true);
    while (contor <= bytesize) {
      recived = Serial1.read();
      reciverBufer[contor] = recived;
      contor++;
      delay(2);
      prev=1;
    }
    setState(reciverBufer);
    memset(reciverBufer, 0, sizeof(reciverBufer));
    if (contor == 5) {
      buttonRead = analogRead(climaPin);
      delay(2);
      writeByte(buttonRead);
      contor = 0;
      
    }
  }
  
  
  

}



void Klima::writeByte(int value) {
  value /= 10;
  for (int i = 0; i <= 7; i++) {
    if (value == value_clima[i]) {
      for (int j = 0; j <= 5; j++) {
        Serial1.write(value_clima1[i][j]);
        delay(2);
      }
    }
  }

}
