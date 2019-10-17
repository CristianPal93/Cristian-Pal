#ifndef SubwooferControl_h
#define SubwooferControl_h
#include "Arduino.h"
class SubwooferControl{
  public:
      SubwooferControl(int udPin=22, int incPin=4,int csPin=23);
      void Level(int val);
      void Save();
      int getActualValue();
      void setActualValue(int val);
  private:
      int val2;
      void WiperDirection(int val);
      void WiperUp(int val);
      void WiperDown(int val);
       int _pinUd;
       int _pinInc;
       int _pinCs;
       int actualValue=100;
  };

  #endif
