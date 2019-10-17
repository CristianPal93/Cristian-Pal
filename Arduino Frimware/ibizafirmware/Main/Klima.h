#ifndef Klima_h
#define Klima_h
#include "Arduino.h"
#define climaPin A1
#define rel 25
class Klima{
  
  char val;
  int oldrecived;
  int fan;
  int state;
  int temp;
  int value_clima[8] = {77, 25, 17, 46, 34, 10, 1, 5};
   int reciverBufer[5] = {0,0,0,0,0};
   const int row = 8;
   const int cols = 6;
    const int value_clima1[8][6] = {{128, 0, 127, 5, 127, 124},
   {129, 0, 127, 5, 127, 123},
  {130, 0, 127, 5, 127, 122},
  {160, 0, 127, 5, 127, 92},
  {192, 0, 127, 5, 127, 60},
  {144, 0, 127, 5, 127, 108},
  {132, 0, 127, 5, 127, 120}, {
    136, 0, 127, 5, 127, 116
  }
};
  public:
      int prev=0;
      bool conected;
      int recived;
      void init();
      int getBuferState();
      int getBuferFan();
      int getBuferTemp();
      void runSystem();
      void setState(int reciverBufer[]);
      void flushSerialBufer();
      bool getConectionStatus();
      void setConectionStatus(bool st);
      
  
  private:
      void writeByte(int value);
      const int bytesize = 4;
      int contor = 0;
      int buttonRead;
      
      

  
 
  
  
  
  
  
  };
  #endif
