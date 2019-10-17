package com.cristianpal.seatibizacenter;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Binder;
import android.os.IBinder;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


/**
 * Created by Cristian Pal on 8/27/2016.
 */
public class FloatingWindow extends Service {
    private WindowManager wm;
    private RelativeLayout ll;
    private LayoutInflater inflater;
    Animation OpenRightDoor;
    Animation CloseRightDoor;

    Animation OpenLeftDoor;
    Animation CloseLeftDoor;

    Animation OpenBackLeftDoor;
    Animation CloseBackLeftDoor;

    Animation OpenBackRightDoor;
    Animation CloseBackRightDoor;
    private Button Leftdoor;
    private Button LeftBackDoor;
    private Button Rightdoor;
    private Button RightBackDoor;
    public ImageView mLeftDoor;

    public ImageView mBackLeftDoor;

    public ImageView mRightDoor;

    public ImageView mBackRightDoor;

    IBinder mBinder = new LocalBinder();


    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class LocalBinder extends Binder {
        public FloatingWindow getServerInstance() {
            return FloatingWindow.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();


        wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ll = (RelativeLayout) inflater.inflate(R.layout.doornotifier, null);


        final LinearLayout.LayoutParams llParameters = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setBackgroundColor(Color.argb(0, 255, 255, 255));
        ll.setLayoutParams(llParameters);
        WindowManager.LayoutParams parameters = new WindowManager.LayoutParams(500, 500, WindowManager.LayoutParams.TYPE_PHONE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.TRANSLUCENT);
        parameters.x = 0;
        parameters.y = 0;
        parameters.gravity = Gravity.CENTER | Gravity.CENTER;
        wm.addView(ll, parameters);
        ll.setVisibility(View.INVISIBLE);
        Leftdoor = (Button) ll.findViewById(R.id.button);
        mLeftDoor = (ImageView) ll.findViewById(R.id.imageView2);
        OpenLeftDoor = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.leftdooropen);
        CloseLeftDoor = AnimationUtils.loadAnimation(getApplication(), R.anim.leftdoorclose);

        Rightdoor = (Button) ll.findViewById(R.id.button3);
        mRightDoor = (ImageView) ll.findViewById(R.id.imageView3);
        OpenRightDoor = AnimationUtils.loadAnimation(getApplication(), R.anim.rightdooropen);
        CloseRightDoor = AnimationUtils.loadAnimation(getApplication(), R.anim.rightdoorclose);

        LeftBackDoor = (Button) ll.findViewById(R.id.button2);
        mBackLeftDoor = (ImageView) ll.findViewById(R.id.imageView5);
        OpenBackLeftDoor = AnimationUtils.loadAnimation(getApplication(), R.anim.leftbackdooropen);
        CloseBackLeftDoor = AnimationUtils.loadAnimation(getApplication(), R.anim.leftbackdoorclose);

        RightBackDoor = (Button) ll.findViewById(R.id.button4);
        mBackRightDoor = (ImageView) ll.findViewById(R.id.imageView4);
        OpenBackRightDoor = AnimationUtils.loadAnimation(getApplication(), R.anim.rightbackdooropen);
        CloseBackRightDoor = AnimationUtils.loadAnimation(getApplication(), R.anim.rightbackdoorclose);}


    public void RBDO() {
        RightBackDoor.postDelayed(new Runnable() {
            public void run() {
                ll.setVisibility(View.VISIBLE);
                mBackRightDoor.startAnimation(OpenBackRightDoor);
            }
        }, 800);
    }
    public void RBDC() {
        RightBackDoor.postDelayed(new Runnable() {

            public void run() {
                ll.setVisibility(View.VISIBLE);
               mBackRightDoor.startAnimation(CloseBackRightDoor);
            }
        },800);
    }
    public void LBDO() {
        LeftBackDoor.postDelayed(new Runnable() {

            public void run() {
                ll.setVisibility(View.VISIBLE);
                mBackLeftDoor.startAnimation(OpenBackLeftDoor);
            }
        },800);
    }
    public void LBDC() {
        LeftBackDoor.postDelayed(new Runnable() {

            public void run() {
                ll.setVisibility(View.VISIBLE);
                mBackLeftDoor.startAnimation(CloseBackLeftDoor);
            }
        },800);
    }
    public void RFDO(){
        Rightdoor.postDelayed(new Runnable() {
            @Override
            public void run() {
                ll.setVisibility(View.VISIBLE);
               mRightDoor.startAnimation(OpenRightDoor);
            }
        },800);
    }
    public void RFDC(){
        Rightdoor.postDelayed(new Runnable() {
            @Override
            public void run() {
                ll.setVisibility(View.VISIBLE);
               mRightDoor.startAnimation(CloseRightDoor);
            }
        },800);
    }
    public void LFDO(){
        Leftdoor.postDelayed(new Runnable() {
            @Override
            public void run() {
                ll.setVisibility(View.VISIBLE);
                mLeftDoor.startAnimation(OpenLeftDoor);
            }
        },800);
    }
    public void LFDC() {

        Leftdoor.postDelayed(new Runnable() {
            @Override
            public void run() {
                ll.setVisibility(View.VISIBLE);
                mLeftDoor.startAnimation(CloseLeftDoor);
            }
        }, 800);
    }
        public void RemoveView(){
     ll.setVisibility(View.INVISIBLE);
    }
    }






