#ifndef powerManagement_h
#define powerManagement_h
#include "Arduino.h"
#define potPin 24
#define pwm 5
#define boster 26
#define rel 25
#define ignition 27
class powerManagement{
  public:
  bool conected;
  void init();
  void Run();
  void setConectionStatus(int st);
  bool getConectionStatus();
  private:
  int counter=0;
  int lastReading2=0;
  int reading;
  int ig=LOW;
  int OldPotRead=LOW;
  int iluminationRead;
  void Ilumination(); 
  long time=0;
  long debounce = 500;
  long debounce2 = 30;
  int val;
  int reading2;
  int flip;
  };
#endif
