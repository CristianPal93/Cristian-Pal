#include "powerManagement.h"


void powerManagement::init() {
  pinMode(potPin, INPUT_PULLUP);
  pinMode(pwm, OUTPUT);
  pinMode(boster, OUTPUT);
  pinMode(rel, OUTPUT);
  pinMode(ignition, INPUT);
  Serial.begin(9600);


}
void powerManagement::Run() {
  reading = digitalRead(potPin);
  reading2 = digitalRead(ignition);
  if (reading == LOW && OldPotRead == LOW && millis() - time > debounce) {

    digitalWrite(rel, LOW);
    digitalWrite(boster, LOW);
    time = millis();
    OldPotRead = HIGH;

  } else if (reading == LOW && OldPotRead == HIGH && millis() - time > debounce) {

    digitalWrite(rel, HIGH);
    digitalWrite(boster, HIGH);
    time = millis();
    OldPotRead = LOW;

  }
  if (reading2 != lastReading2 && millis() - time > debounce2) {

    counter++;
    time = millis();

  }
  lastReading2 = reading2;

  if (counter == 1) {
    digitalWrite(rel, HIGH);
    digitalWrite(boster, HIGH);
    conected = true;
  } else if (counter == 2) {

    digitalWrite(rel, LOW);
    digitalWrite(boster, LOW);
    conected=false;
    counter = 0;

  } 
    

  
  
  Ilumination();

}
void powerManagement::setConectionStatus(int status) {
  conected = status;
}
bool powerManagement::getConectionStatus() {
  return conected;
}

void powerManagement::Ilumination() {

  if (conected == true) {


    analogWrite(pwm, 0);
  } else {
    analogWrite(pwm, 255);
  }
}
