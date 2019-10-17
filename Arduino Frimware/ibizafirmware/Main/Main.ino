#include <everytime.h>
#include <Wire.h>
#include "powerManagement.h"
#include "Klima.h"
#include "SubwooferControl.h"
#include "PT2313.h"
#include "24LC16BT.h"
#include "Rotary.h"
#define climaPin A1
#define boster 26
Klima clima;
powerManagement power;
PT2313 audioChip;
SubwooferControl sub = SubwooferControl();
Rotary r = Rotary(2, 3);
int oldFan;
byte *P;
int Fan;
int Mod;
int oldMod;
int Temp;
int oldTemp;
int oldreading;
int curentReading;
char reading = '0';
const int maxVolume = 50;
const int minVolume = 0;
const int maxBalance = 31;
const int minBalance = -31;
const int maxTreble = 7;
const int minTreble = -7;
const int maxBass = 7;
const int minBass = -7;
const int maxFader = 31;
const int minFader = -31;
const int maxSubwoofer = 10;
const int minSubwoofer = 0;
bool Loud = false;
int subwooferLevel = 0;
const int maxSendVolume = 21;
const int minSendVolume = 0;
int sentVolume = 0;
int oldsentVolume = 0;
const int maxSendBalance = 9;
const int minSendBalance = -9;
int sentBalance = 0;
int oldsentBalance=0;
const int maxSendFader = 9;
const int minSendFader = -9;
int sentFader = 0;
int oldsentFader=0;
int volumeLevel = 0;
int bassLevel = 0;
int trebleLevel = 0;
int balanceLevel = 0;
int faderLevel = 0;

void setup() {
   pinMode(boster, OUTPUT);
  pinMode(climaPin, INPUT_PULLUP);
  audioChip.initialize(0, true); //source 1,mute on
  audioChip.source(0);//select your source 0...3
  audioChip.volume(0);//Vol 0...62 : 63=muted
  audioChip.gain(2);//gain 0...11.27 db
  audioChip.loudness(true);//true or false
  audioChip.bass(0);//bass -7...+7
  audioChip.treble(0);//treble -7...+7
  audioChip.balance(0);
  audioChip.fader(0);
  Serial.begin(9500);
  clima.init();
  power.init();
  r.begin(true);
  PCICR |= (1 << PCIE2);
  PCMSK2 |= (1 << PCINT18) | (1 << PCINT19);
  sei();
  sub.Level(10);

}



void loop() {
  if (Serial) {
    if(digitalRead(boster)==HIGH){
    if (Serial.available() > 0) {
      int reading2 = Serial.read();
      switch (reading2) {
        case '0':
          reading = '0';
          break;
        case '1':
          reading = '1';
          break;
        case '2':
          reading = '2';
          break;
        case '3':
          reading = '3';
          break;
        case '4':
          reading = '4';
          break;
        case '5':
          audioChip.source(0);
          break;
        case '6':
          audioChip.source(1);
          break;
        case '7':
          audioChip.source(2);
          break;
        case '8':
          if (subwooferLevel < maxSubwoofer) {
            subwooferLevel += 1;
            sub.Level(subwooferLevel);
          }
          break;
        case'9':
          if (subwooferLevel > minSubwoofer) {
            subwooferLevel -= 1;
            sub.Level(subwooferLevel);
          }
          break;
        case'B':
          audioChip.loudness(true);
          break;
        case'C':
          audioChip.loudness(false);
          break;
        case 'v':
          audioChip.balance(0);
          balanceLevel = 0;
          break;
        case 'w':
          audioChip.fader(0);
          faderLevel = 0;
          break;
      }
    }

    unsigned char result = r.process();


    if (result == DIR_NONE) {


    }


    else if (result == DIR_CW) {

      switch (reading) {
        case '0':
          if (volumeLevel < maxVolume) {
           
            audioChip.volume(volumeLevel);
             volumeLevel++;
            sentVolume = map(volumeLevel, 0, 50, 0, 21);

            if (sentVolume <= maxSendVolume) {
              if (oldsentVolume != sentVolume) {
                Serial.write("P");

              } oldsentVolume = sentVolume;
            }
          }
          break;
        case '1':
          if (bassLevel < maxBass) {
            bassLevel++;
            audioChip.bass(bassLevel);
            Serial.write("I");
          }
          break;

        case '2':
          if (trebleLevel < maxTreble) {
            trebleLevel++;
            audioChip.treble(trebleLevel);
            Serial.write("F");
          }
          break;


        case '3':
          if (balanceLevel <= maxBalance) {
            balanceLevel++;
            audioChip.balance(balanceLevel);
            sentBalance = map(balanceLevel, -31, 31, -9, 9);
            if (sentBalance < maxSendBalance) {
              if(oldsentBalance!=sentBalance){
              Serial.write("U");
              }oldsentBalance=sentBalance;
            }
          }
          break;



        case '4':
          if (faderLevel <= maxFader) {
            faderLevel++;
            audioChip.fader(faderLevel);
            sentFader = map(faderLevel, -31, 31, -9, 9);
            if (sentFader < maxSendFader) {
              if(oldsentFader!=sentFader){
              Serial.write("E");
            }oldsentFader=sentFader;
            }
          }
          break;




      }
    }

    else if (result == DIR_CCW) {
      switch (reading) {
        case '0':
          if (volumeLevel > minVolume) {
            audioChip.volume(volumeLevel);
            volumeLevel--;
            sentVolume = map(volumeLevel, 0, 50, 0, 21);
            if (sentVolume >= minSendVolume) {
              if (oldsentVolume != sentVolume) {
                Serial.write("S");


              } oldsentVolume = sentVolume;


            }
          }
          break;
        case '1':
          if (bassLevel >= minBass) {
            bassLevel--;
            audioChip.bass(bassLevel);
            Serial.write("H");
          }
          break;
        case '2':
          if (trebleLevel >= minTreble) {
            trebleLevel--;
            audioChip.treble(trebleLevel);
            Serial.write("D");
          }
          break;


        case '3':
          if (balanceLevel >= minBalance) {
            balanceLevel--;
            audioChip.balance(balanceLevel);
            sentBalance = map(balanceLevel, -31, 31, -9, 9);
            if (sentBalance > minSendBalance) {
              if(oldsentBalance!=sentBalance){
              
              Serial.write("T");
              }oldsentBalance=sentBalance;
            }
          }
          break;



        case '4':
          if (faderLevel >= minFader) {
            faderLevel--;
            audioChip.fader(faderLevel);
            sentFader = map(faderLevel, -31, 31, -9, 9);
            if (sentFader > minSendFader) {
              if(oldsentFader!=sentFader){
              Serial.write("C");
            }oldsentFader=sentFader;
            }
          }
          break;

      }

    }
  }
  }

  if (Serial1.available() > 0) {
    every(1) {
      Fan = clima.getBuferFan();
      Mod = clima.getBuferState();
      Temp = clima.getBuferTemp();
      if (Fan != oldFan) {
        char val = map(Fan, 0, 6, 98, 104);
        Serial.write(val);
        delay(1);
      }
      oldFan = Fan;
      if (Temp != oldTemp) {
        char val2 = map(Temp, 0, 12, 105, 117);
        Serial.write(val2);
      }
      oldTemp = Temp;
    }
    if (Mod != oldMod) {
      if (Mod == 129) {
        Serial.write(48);
      }
      else if (Mod == 177) {
        Serial.write(49);
      }
      else if (Mod == 145) {
        Serial.write(50);
      }
      else if (Mod == 165) {
        Serial.write(51);
      }
      else if (Mod == 161) {
        Serial.write(52);
      }
      else if (Mod == 133) {
        Serial.write(53);
      }


    }
    oldMod = Mod;
  }



  power.Run();
  clima.runSystem();
  
  

}
