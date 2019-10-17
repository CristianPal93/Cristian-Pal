#include "Arduino.h"
#include "SubwooferControl.h"

SubwooferControl::SubwooferControl(int udPin,int incPin,int csPin){
  pinMode (csPin, OUTPUT);
  pinMode (udPin, OUTPUT);
  pinMode (incPin, OUTPUT);
  digitalWrite(incPin, HIGH);
  digitalWrite(csPin, LOW);
  _pinUd = udPin;
  _pinInc = incPin;
  _pinCs = csPin;
  
}

void SubwooferControl::Level(int val) {
  val2=val;
  WiperDirection(val2);

}
int  SubwooferControl::getActualValue() {
  return actualValue;
}
void  SubwooferControl::setActualValue(int val) {
  actualValue = val;
}
void SubwooferControl::WiperDirection(int val) {
  if ((val * 10) > actualValue) {
    WiperUp((val * 10));

  } else if ((val * 10) < actualValue) {
    WiperDown((val * 10));

  }
}
void SubwooferControl::WiperUp(int val) {
  while (actualValue < val) {
    digitalWrite(_pinUd, LOW); delayMicroseconds(5);  // Set to increment
    digitalWrite(_pinInc, LOW); delayMicroseconds(5);  // Pulse INC pin low
    digitalWrite(_pinInc, HIGH);
   Serial.println(actualValue);
    actualValue++;
  }
}
void SubwooferControl::WiperDown(int val) {
  while (actualValue > val) {
    digitalWrite(_pinUd, HIGH); delayMicroseconds(5);  // Set to increment
    digitalWrite(_pinInc, LOW); delayMicroseconds(5);  // Pulse INC pin low
    digitalWrite(_pinInc, HIGH);
   Serial.println(actualValue);
    actualValue--;
  }
}

void SubwooferControl::Save() {
  digitalWrite(_pinCs, HIGH);
  delay(50);
  digitalWrite(_pinCs, LOW);
}
