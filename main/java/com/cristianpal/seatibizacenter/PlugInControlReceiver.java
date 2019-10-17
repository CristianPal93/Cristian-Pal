package com.cristianpal.seatibizacenter;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.widget.TextView;
import android.widget.Toast;

import static com.cristianpal.seatibizacenter.Home.CMDNAME;
import static com.cristianpal.seatibizacenter.Home.CMDPAUSE;
import static com.cristianpal.seatibizacenter.Home.CMDPLAY;
import static com.cristianpal.seatibizacenter.Home.SERVICECMD;


public class PlugInControlReceiver extends BroadcastReceiver {


    public static boolean wasScreenOn = true;

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(Intent.ACTION_POWER_CONNECTED)) {

        }
            if (action.equals(Intent.ACTION_POWER_DISCONNECTED)) {

                Intent i = new Intent(context.getPackageManager().getLaunchIntentForPackage("com.shutdown.cristianpal.shutdown"));
                context.startActivities(new Intent[]{i});
                AudioManager mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
                if (mAudioManager.isMusicActive()) {
                    Intent p = new Intent(SERVICECMD);
                    p.putExtra(CMDNAME, CMDPAUSE);
                    context.sendBroadcast(p);

                }


            }
            if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
                wasScreenOn = false;

            } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {

                wasScreenOn = true;
            }
        }


    }










