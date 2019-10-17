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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Rauk on 10/4/2016.
 */

public class SoundControlService extends Service{
    private WindowManager wm1;
    private RelativeLayout ll1;
    private RelativeLayout ll2;
    private RelativeLayout ll3;
    private RelativeLayout ll4;
    private  RelativeLayout ll5;
    private LayoutInflater inflater;
    public ImageView a;
    public ImageView b;
    public ImageView c;
    public ImageView d;
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public ImageView n;
    public ImageView o;
    public ImageView p;
    public ImageView q;
    public ImageView r;
    public ImageView s;
    public ImageView t;
    public ImageView u;
    public ImageView bar;
    public TextView text;
    public ImageView speaker;
    public ImageView a1;
    public ImageView b1;
    public ImageView c1;
    public ImageView d1;
    public ImageView e1;
    public ImageView f1;
    public ImageView g1;
    public ImageView h1;
    public ImageView i1;
    public ImageView k1;
    public ImageView l1;
    public ImageView m1;
    public ImageView n1;
    public ImageView o1;
    public ImageView p1;
    public ImageView q1;
    public ImageView r1;
    public ImageView s1;
    public ImageView a2;
    public ImageView b2;
    public ImageView c2;
    public ImageView d2;
    public ImageView e2;
    public ImageView f2;
    public ImageView g2;
    public ImageView h2;
    public ImageView i2;
    public ImageView k2;
    public ImageView l2;
    public ImageView m2;
    public ImageView n2;
    public ImageView o2;
    public ImageView p2;
    public ImageView q2;
    public ImageView r2;
    public ImageView s2;
    public ImageView c3;
    public ImageView d3;
    public ImageView e3;
    public ImageView f3;
    public ImageView g3;
    public ImageView h3;
    public ImageView i3;
    public ImageView k3;
    public ImageView l3;
    public ImageView m3;
    public ImageView n3;
    public ImageView o3;
    public ImageView p3;
    public ImageView q3;
    public ImageView c4;
    public ImageView d4;
    public ImageView e4;
    public ImageView f4;
    public ImageView g4;
    public ImageView h4;
    public ImageView i4;
    public ImageView k4;
    public ImageView l4;
    public ImageView m4;
    public ImageView n4;
    public ImageView o4;
    public ImageView p4;
    public ImageView q4;




    IBinder mBinder = new LocalBinder();


    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class LocalBinder extends Binder {
        public SoundControlService getServerInstance() {
            return SoundControlService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        wm1 = (WindowManager) getSystemService(WINDOW_SERVICE);
        inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ll1 = (RelativeLayout) inflater.inflate(R.layout.volume, null);
        ll2 = (RelativeLayout) inflater.inflate(R.layout.balance, null);
        ll3 = (RelativeLayout) inflater.inflate(R.layout.fader, null);
        ll4 = (RelativeLayout) inflater.inflate(R.layout.bass, null);
        ll5 = (RelativeLayout) inflater.inflate(R.layout.treble, null);


        final LinearLayout.LayoutParams llParameters = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ll1.setBackgroundColor(Color.argb(0, 255, 255, 255));
        ll1.setLayoutParams(llParameters);
        WindowManager.LayoutParams parameters = new WindowManager.LayoutParams(1300, 100, WindowManager.LayoutParams.TYPE_PHONE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.TRANSLUCENT);
        parameters.x = 0;
        parameters.y = 300;
        parameters.gravity = Gravity.CENTER | Gravity.CENTER;
        wm1.addView(ll1, parameters);
        wm1.addView(ll2, parameters);
        wm1.addView(ll3, parameters);
        wm1.addView(ll4, parameters);
        wm1.addView(ll5, parameters);
        ll2.setVisibility(View.INVISIBLE);
        ll3.setVisibility(View.INVISIBLE);
        ll4.setVisibility(View.INVISIBLE);
        ll5.setVisibility(View.INVISIBLE);
        ll1.setVisibility(View.INVISIBLE);
        speaker = (ImageView) ll1.findViewById(R.id.imageView2);
        text = (TextView) ll1.findViewById(R.id.textView);
        bar = (ImageView) ll1.findViewById(R.id.imageView);
        a = (ImageView) ll1.findViewById(R.id.imageView3);
        b = (ImageView) ll1.findViewById(R.id.imageView4);
        c = (ImageView) ll1.findViewById(R.id.imageView5);
        d = (ImageView) ll1.findViewById(R.id.imageView6);
        e = (ImageView) ll1.findViewById(R.id.imageView7);
        f = (ImageView) ll1.findViewById(R.id.imageView8);
        g = (ImageView) ll1.findViewById(R.id.imageView9);
        h = (ImageView) ll1.findViewById(R.id.imageView10);
        i = (ImageView) ll1.findViewById(R.id.imageView11);
        j = (ImageView) ll1.findViewById(R.id.imageView12);
        k = (ImageView) ll1.findViewById(R.id.imageView13);
        l = (ImageView) ll1.findViewById(R.id.imageView14);
        m = (ImageView) ll1.findViewById(R.id.imageView15);
        n = (ImageView) ll1.findViewById(R.id.imageView16);
        o = (ImageView) ll1.findViewById(R.id.imageView17);
        p = (ImageView) ll1.findViewById(R.id.imageView18);
        q = (ImageView) ll1.findViewById(R.id.imageView19);
        r = (ImageView) ll1.findViewById(R.id.imageView20);
        s = (ImageView) ll1.findViewById(R.id.imageView21);
        t = (ImageView) ll1.findViewById(R.id.imageView22);
        u = (ImageView) ll1.findViewById(R.id.imageView23);
        a1 = (ImageView) ll2.findViewById(R.id.imageView26);
        b1 = (ImageView) ll2.findViewById(R.id.imageView27);
        c1 = (ImageView) ll2.findViewById(R.id.imageView28);
        d1 = (ImageView) ll2.findViewById(R.id.imageView29);
        e1 = (ImageView) ll2.findViewById(R.id.imageView30);
        f1 = (ImageView) ll2.findViewById(R.id.imageView31);
        g1 = (ImageView) ll2.findViewById(R.id.imageView32);
        h1 = (ImageView) ll2.findViewById(R.id.imageView33);
        i1 = (ImageView) ll2.findViewById(R.id.imageView34);
        k1 = (ImageView) ll2.findViewById(R.id.imageView36);
        l1 = (ImageView) ll2.findViewById(R.id.imageView37);
        m1 = (ImageView) ll2.findViewById(R.id.imageView38);
        n1 = (ImageView) ll2.findViewById(R.id.imageView39);
        o1 = (ImageView) ll2.findViewById(R.id.imageView40);
        p1 = (ImageView) ll2.findViewById(R.id.imageView41);
        q1 = (ImageView) ll2.findViewById(R.id.imageView42);
        r1 = (ImageView) ll2.findViewById(R.id.imageView43);
        s1 = (ImageView) ll2.findViewById(R.id.imageView44);
        a2 = (ImageView) ll3.findViewById(R.id.imageView45);
        b2 = (ImageView) ll3.findViewById(R.id.imageView46);
        c2 = (ImageView) ll3.findViewById(R.id.imageView47);
        d2 = (ImageView) ll3.findViewById(R.id.imageView48);
        e2 = (ImageView) ll3.findViewById(R.id.imageView49);
        f2 = (ImageView) ll3.findViewById(R.id.imageView50);
        g2 = (ImageView) ll3.findViewById(R.id.imageView51);
        h2 = (ImageView) ll3.findViewById(R.id.imageView52);
        i2 = (ImageView) ll3.findViewById(R.id.imageView53);
        k2 = (ImageView) ll3.findViewById(R.id.imageView55);
        l2 = (ImageView) ll3.findViewById(R.id.imageView56);
        m2 = (ImageView) ll3.findViewById(R.id.imageView57);
        n2 = (ImageView) ll3.findViewById(R.id.imageView58);
        o2 = (ImageView) ll3.findViewById(R.id.imageView59);
        p2 = (ImageView) ll3.findViewById(R.id.imageView60);
        q2 = (ImageView) ll3.findViewById(R.id.imageView61);
        r2 = (ImageView) ll3.findViewById(R.id.imageView62);
        s2 = (ImageView) ll3.findViewById(R.id.imageView63);
        c3 = (ImageView) ll4.findViewById(R.id.imageView64);
        d3 = (ImageView) ll4.findViewById(R.id.imageView65);
        e3 = (ImageView) ll4.findViewById(R.id.imageView66);
        f3 = (ImageView) ll4.findViewById(R.id.imageView67);
        g3 = (ImageView) ll4.findViewById(R.id.imageView68);
        h3 = (ImageView) ll4.findViewById(R.id.imageView69);
        i3 = (ImageView) ll4.findViewById(R.id.imageView70);
        k3 = (ImageView) ll4.findViewById(R.id.imageView72);
        l3 = (ImageView) ll4.findViewById(R.id.imageView73);
        m3 = (ImageView) ll4.findViewById(R.id.imageView74);
        n3 = (ImageView) ll4.findViewById(R.id.imageView75);
        o3 = (ImageView) ll4.findViewById(R.id.imageView76);
        p3 = (ImageView) ll4.findViewById(R.id.imageView77);
        q3 = (ImageView) ll4.findViewById(R.id.imageView78);
        c4 = (ImageView) ll5.findViewById(R.id.imageView3);
        d4 = (ImageView) ll5.findViewById(R.id.imageView4);
        e4 = (ImageView) ll5.findViewById(R.id.imageView5);
        f4 = (ImageView) ll5.findViewById(R.id.imageView6);
        g4 = (ImageView) ll5.findViewById(R.id.imageView7);
        h4 = (ImageView) ll5.findViewById(R.id.imageView8);
        i4 = (ImageView) ll5.findViewById(R.id.imageView9);
        k4 = (ImageView) ll5.findViewById(R.id.imageView11);
        l4 = (ImageView) ll5.findViewById(R.id.imageView12);
        m4 = (ImageView) ll5.findViewById(R.id.imageView13);
        n4 = (ImageView) ll5.findViewById(R.id.imageView14);
        o4 = (ImageView) ll5.findViewById(R.id.imageView15);
        p4 = (ImageView) ll5.findViewById(R.id.imageView16);
        q4 = (ImageView) ll5.findViewById(R.id.imageView17);


        a.setTag("1");
        u.setTag("1");
        i1.setTag("1");
        k1.setTag("1");
        i2.setTag("1");
        k2.setTag("1");
        i3.setTag("1");
        k3.setTag("1");
        i4.setTag("1");
        k4.setTag("1");


    }
public void delay(){

            ll2.setVisibility(View.INVISIBLE);
            ll3.setVisibility(View.INVISIBLE);
            ll4.setVisibility(View.INVISIBLE);
            ll5.setVisibility(View.INVISIBLE);
            ll1.setVisibility(View.INVISIBLE);





}


 public void view1(){
        ll1.setVisibility(View.VISIBLE);
        ll2.setVisibility(View.INVISIBLE);
        ll3.setVisibility(View.INVISIBLE);
        ll4.setVisibility(View.INVISIBLE);
        ll5.setVisibility(View.INVISIBLE);
    }

    public void view2(){
ll1.setVisibility(View.INVISIBLE);
        ll2.setVisibility(View.VISIBLE);
        ll3.setVisibility(View.INVISIBLE);
        ll4.setVisibility(View.INVISIBLE);
        ll5.setVisibility(View.INVISIBLE);
    }
    public void view3(){
        ll3.setVisibility(View.VISIBLE);
        ll2.setVisibility(View.INVISIBLE);
        ll1.setVisibility(View.INVISIBLE);
        ll4.setVisibility(View.INVISIBLE);
        ll5.setVisibility(View.INVISIBLE);
    }
    public void view4(){
        ll5.setVisibility(View.INVISIBLE);
        ll3.setVisibility(View.INVISIBLE);
        ll2.setVisibility(View.INVISIBLE);
        ll1.setVisibility(View.INVISIBLE);
        ll4.setVisibility(View.VISIBLE);
    }
    public void view5(){
        ll3.setVisibility(View.INVISIBLE);
        ll2.setVisibility(View.INVISIBLE);
        ll1.setVisibility(View.INVISIBLE);
        ll4.setVisibility(View.INVISIBLE);
        ll5.setVisibility(View.VISIBLE);
    }
    public void resetbalance(){
       a1.setImageResource(R.drawable.wihtesquare);
        b1.setImageResource(R.drawable.wihtesquare);
        c1.setImageResource(R.drawable.wihtesquare);
        d1.setImageResource(R.drawable.wihtesquare);
        e1.setImageResource(R.drawable.wihtesquare);
        f1.setImageResource(R.drawable.wihtesquare);
        g1.setImageResource(R.drawable.wihtesquare);
        h1.setImageResource(R.drawable.wihtesquare);
        i1.setImageResource(R.drawable.wihtesquare);
        k1.setImageResource(R.drawable.wihtesquare);
        l1.setImageResource(R.drawable.wihtesquare);
        m1.setImageResource(R.drawable.wihtesquare);
        n1.setImageResource(R.drawable.wihtesquare);
        o1.setImageResource(R.drawable.wihtesquare);
        p1.setImageResource(R.drawable.wihtesquare);
        q1.setImageResource(R.drawable.wihtesquare);
        r1.setImageResource(R.drawable.wihtesquare);
        s1.setImageResource(R.drawable.wihtesquare);
     i1.setTag("1");
        k1.setTag("1");
    }
    public void resetfader(){
        a2.setImageResource(R.drawable.wihtesquare);
        b2.setImageResource(R.drawable.wihtesquare);
        c2.setImageResource(R.drawable.wihtesquare);
        d2.setImageResource(R.drawable.wihtesquare);
        e2.setImageResource(R.drawable.wihtesquare);
        f2.setImageResource(R.drawable.wihtesquare);
        g2.setImageResource(R.drawable.wihtesquare);
        h2.setImageResource(R.drawable.wihtesquare);
        i2.setImageResource(R.drawable.wihtesquare);
        k2.setImageResource(R.drawable.wihtesquare);
        l2.setImageResource(R.drawable.wihtesquare);
        m2.setImageResource(R.drawable.wihtesquare);
        n2.setImageResource(R.drawable.wihtesquare);
        o2.setImageResource(R.drawable.wihtesquare);
        p2.setImageResource(R.drawable.wihtesquare);
        q2.setImageResource(R.drawable.wihtesquare);
        r2.setImageResource(R.drawable.wihtesquare);
        s2.setImageResource(R.drawable.wihtesquare);
        i2.setTag("1");
        k2.setTag("1");
    }
    public void resetbass(){

        c3.setImageResource(R.drawable.wihtesquare);
        d3.setImageResource(R.drawable.wihtesquare);
        e3.setImageResource(R.drawable.wihtesquare);
        f3.setImageResource(R.drawable.wihtesquare);
        g3.setImageResource(R.drawable.wihtesquare);
        h3.setImageResource(R.drawable.wihtesquare);
        i3.setImageResource(R.drawable.wihtesquare);
        k3.setImageResource(R.drawable.wihtesquare);
        l3.setImageResource(R.drawable.wihtesquare);
        m3.setImageResource(R.drawable.wihtesquare);
        n3.setImageResource(R.drawable.wihtesquare);
        o3.setImageResource(R.drawable.wihtesquare);
        p3.setImageResource(R.drawable.wihtesquare);
        q3.setImageResource(R.drawable.wihtesquare);

        i3.setTag("1");
        k3.setTag("1");
    }
    public void resettreble(){

        c4.setImageResource(R.drawable.wihtesquare);
        d4.setImageResource(R.drawable.wihtesquare);
        e4.setImageResource(R.drawable.wihtesquare);
        f4.setImageResource(R.drawable.wihtesquare);
        g4.setImageResource(R.drawable.wihtesquare);
        h4.setImageResource(R.drawable.wihtesquare);
        i4.setImageResource(R.drawable.wihtesquare);
        k4.setImageResource(R.drawable.wihtesquare);
        l4.setImageResource(R.drawable.wihtesquare);
        m4.setImageResource(R.drawable.wihtesquare);
        n4.setImageResource(R.drawable.wihtesquare);
        o4.setImageResource(R.drawable.wihtesquare);
        p4.setImageResource(R.drawable.wihtesquare);
        q4.setImageResource(R.drawable.wihtesquare);

        i4.setTag("1");
        k4.setTag("1");
    }
    public void trebleminus(){
        if ("1".equals(i4.getTag())) {
            i4.setImageResource(R.drawable.redsuqare);
            i4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i4.setTag("2");
                    k4.setTag("10");
                }
            }, 10);
        }
        if ("2".equals(i4.getTag())) {
            h4.setImageResource(R.drawable.redsuqare);
            h4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i4.setTag("3");
                    k4.setTag("11");
                }
            }, 10);

        }
        if ("3".equals(i4.getTag())) {
            g4.setImageResource(R.drawable.redsuqare);
            g4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i4.setTag("4");
                    k4.setTag("12");
                }
            }, 10);
        }
        if ("4".equals(i4.getTag())) {
            f4.setImageResource(R.drawable.redsuqare);
            f4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i4.setTag("5");
                    k4.setTag("13");
                }
            }, 10);

        }
        if ("5".equals(i4.getTag())) {
            e4.setImageResource(R.drawable.redsuqare);
            e4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i4.setTag("6");
                    k4.setTag("14");
                }
            }, 10);
        }
        if ("6".equals(i4.getTag())) {
            d4.setImageResource(R.drawable.redsuqare);
            d4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i4.setTag("7");
                    k4.setTag("15");

                }
            }, 10);

        }
        if ("7".equals(i4.getTag())) {
            c4.setImageResource(R.drawable.redsuqare);
            c4.postDelayed(new Runnable() {
                @Override
                public void run() {

                    k4.setTag("16");
                }
            }, 10);
        }



        if ("10".equals(i4.getTag())) {
            k4.setImageResource(R.drawable.wihtesquare);
            k4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i4.setTag("1");
                    k4.setTag("1");

                }
            }, 10);
        }
        if ("11".equals(i4.getTag())) {
            l4.setImageResource(R.drawable.wihtesquare);
            l4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i4.setTag("10");
                    k4.setTag("2");

                }
            }, 10);
        }
        if ("12".equals(i4.getTag())) {
            m4.setImageResource(R.drawable.wihtesquare);
            m4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i4.setTag("11");
                    k4.setTag("3");
                }
            }, 10);
        }
        if ("13".equals(i4.getTag())) {
            n4.setImageResource(R.drawable.wihtesquare);
            n4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i4.setTag("12");
                    k4.setTag("4");
                }
            }, 10);

        }
        if ("14".equals(i4.getTag())) {
            o4.setImageResource(R.drawable.wihtesquare);
            o4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i4.setTag("13");
                    k4.setTag("5");
                }
            }, 10);
        }
        if ("15".equals(i4.getTag())) {
            p4.setImageResource(R.drawable.wihtesquare);
            p4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i4.setTag("14");
                    k4.setTag("6");

                }
            }, 10);

        }
        if ("16".equals(i4.getTag())) {
            q4.setImageResource(R.drawable.wihtesquare);
            q4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i4.setTag("15");
                    k4.setTag("7");
                }
            }, 10);
        }


    }
    public void trebleplus(){
        if ("16".equals(k4.getTag())) {
            c4.setImageResource(R.drawable.wihtesquare);
            c4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k4.setTag("15");
                    i4.setTag("7");
                }
            }, 10);
        }
        if ("15".equals(k4.getTag())) {
            d4.setImageResource(R.drawable.wihtesquare);
            d4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k4.setTag("14");
                    i4.setTag("6");
                }
            }, 10);

        }
        if ("14".equals(k4.getTag())) {
            e4.setImageResource(R.drawable.wihtesquare);
            e4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k4.setTag("13");
                    i4.setTag("5");
                }
            }, 10);
        }
        if ("13".equals(k4.getTag())) {
            f4.setImageResource(R.drawable.wihtesquare);
            f4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k4.setTag("12");
                    i4.setTag("4");
                }
            }, 10);

        }
        if ("12".equals(k4.getTag())) {
            g4.setImageResource(R.drawable.wihtesquare);
            g4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k4.setTag("11");
                    i4.setTag("3");
                }
            }, 10);
        }
        if ("11".equals(k4.getTag())) {
            h4.setImageResource(R.drawable.wihtesquare);
            h4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k4.setTag("10");
                    i4.setTag("2");
                }
            }, 10);

        }
        if ("10".equals(k4.getTag())) {
            i4.setImageResource(R.drawable.wihtesquare);
            i4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k4.setTag("1");
                    i4.setTag("1");

                }
            }, 10);
        }
        if ("1".equals(k4.getTag())) {
            k4.setImageResource(R.drawable.redsuqare);
            k4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k4.setTag("2");
                    i4.setTag("10");

                }
            }, 10);
        }
        if ("2".equals(k4.getTag())) {
            l4.setImageResource(R.drawable.redsuqare);
            l4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k4.setTag("3");
                    i4.setTag("11");
                }
            }, 10);
        }
        if ("3".equals(k4.getTag())) {
            m4.setImageResource(R.drawable.redsuqare);
            m4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k4.setTag("4");
                    i4.setTag("12");
                }
            }, 10);
        }
        if ("4".equals(k4.getTag())) {
            n4.setImageResource(R.drawable.redsuqare);
            n4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k4.setTag("5");
                    i4.setTag("13");
                }
            }, 10);

        }
        if ("5".equals(k4.getTag())) {
            o4.setImageResource(R.drawable.redsuqare);
            o4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k4.setTag("6");
                    i4.setTag("14");
                }
            }, 10);
        }
        if ("6".equals(k4.getTag())) {
            p4.setImageResource(R.drawable.redsuqare);
            p4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k4.setTag("7");
                    i4.setTag("15");
                }
            }, 10);

        }
        if ("7".equals(k4.getTag())) {
            q4.setImageResource(R.drawable.redsuqare);
            q4.postDelayed(new Runnable() {
                @Override
                public void run() {

                    i4.setTag("16");
                }
            }, 10);
        }
    }

    public void bassminus(){

         if ("1".equals(i3.getTag())) {
             i3.setImageResource(R.drawable.redsuqare);
             i3.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i3.setTag("2");
                     k3.setTag("10");
                 }
             }, 10);
         }
         if ("2".equals(i3.getTag())) {
             h3.setImageResource(R.drawable.redsuqare);
             h3.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i3.setTag("3");
                     k3.setTag("11");
                 }
             }, 10);

         }
         if ("3".equals(i3.getTag())) {
             g3.setImageResource(R.drawable.redsuqare);
             g3.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i3.setTag("4");
                     k3.setTag("12");
                 }
             }, 10);
         }
         if ("4".equals(i3.getTag())) {
             f3.setImageResource(R.drawable.redsuqare);
             f3.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i3.setTag("5");
                     k3.setTag("13");
                 }
             }, 10);

         }
         if ("5".equals(i3.getTag())) {
             e3.setImageResource(R.drawable.redsuqare);
             e3.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i3.setTag("6");
                     k3.setTag("14");
                 }
             }, 10);
         }
         if ("6".equals(i3.getTag())) {
             d3.setImageResource(R.drawable.redsuqare);
             d3.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i3.setTag("7");
                     k3.setTag("15");

                 }
             }, 10);

         }
         if ("7".equals(i3.getTag())) {
             c3.setImageResource(R.drawable.redsuqare);
             c3.postDelayed(new Runnable() {
                 @Override
                 public void run() {

                     k3.setTag("16");
                 }
             }, 10);
         }



         if ("10".equals(i3.getTag())) {
             k3.setImageResource(R.drawable.wihtesquare);
             k3.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i3.setTag("1");
                     k3.setTag("1");

                 }
             }, 10);
         }
         if ("11".equals(i3.getTag())) {
             l3.setImageResource(R.drawable.wihtesquare);
             l3.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i3.setTag("10");
                     k3.setTag("2");

                 }
             }, 10);
         }
         if ("12".equals(i3.getTag())) {
             m3.setImageResource(R.drawable.wihtesquare);
             m3.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i3.setTag("11");
                     k3.setTag("3");
                 }
             }, 10);
         }
         if ("13".equals(i3.getTag())) {
             n3.setImageResource(R.drawable.wihtesquare);
             n3.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i3.setTag("12");
                     k3.setTag("4");
                 }
             }, 10);

         }
         if ("14".equals(i3.getTag())) {
             o3.setImageResource(R.drawable.wihtesquare);
             o3.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i3.setTag("13");
                     k3.setTag("5");
                 }
             }, 10);
         }
         if ("15".equals(i3.getTag())) {
             p3.setImageResource(R.drawable.wihtesquare);
             p3.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i3.setTag("14");
                     k3.setTag("6");

                 }
             }, 10);

         }
         if ("16".equals(i3.getTag())) {
             q3.setImageResource(R.drawable.wihtesquare);
             q3.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i3.setTag("15");
                     k3.setTag("7");
                 }
             }, 10);
         }


     }
    public void bassplus(){
        if ("16".equals(k3.getTag())) {
            c3.setImageResource(R.drawable.wihtesquare);
            c3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k3.setTag("15");
                    i3.setTag("7");
                }
            }, 10);
        }
        if ("15".equals(k3.getTag())) {
            d3.setImageResource(R.drawable.wihtesquare);
            d3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k3.setTag("14");
                    i3.setTag("6");
                }
            }, 10);

        }
        if ("14".equals(k3.getTag())) {
            e3.setImageResource(R.drawable.wihtesquare);
            e3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k3.setTag("13");
                    i3.setTag("5");
                }
            }, 10);
        }
        if ("13".equals(k3.getTag())) {
            f3.setImageResource(R.drawable.wihtesquare);
            f3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k3.setTag("12");
                    i3.setTag("4");
                }
            }, 10);

        }
        if ("12".equals(k3.getTag())) {
            g3.setImageResource(R.drawable.wihtesquare);
            g3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k3.setTag("11");
                    i3.setTag("3");
                }
            }, 10);
        }
        if ("11".equals(k3.getTag())) {
            h3.setImageResource(R.drawable.wihtesquare);
            h3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k3.setTag("10");
                    i3.setTag("2");
                }
            }, 10);

        }
        if ("10".equals(k3.getTag())) {
            i3.setImageResource(R.drawable.wihtesquare);
            i3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k3.setTag("1");
                    i3.setTag("1");

                }
            }, 10);
        }
        if ("1".equals(k3.getTag())) {
            k3.setImageResource(R.drawable.redsuqare);
            k3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k3.setTag("2");
                    i3.setTag("10");

                }
            }, 10);
        }
        if ("2".equals(k3.getTag())) {
            l3.setImageResource(R.drawable.redsuqare);
            l3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k3.setTag("3");
                    i3.setTag("11");
                }
            }, 10);
        }
        if ("3".equals(k3.getTag())) {
            m3.setImageResource(R.drawable.redsuqare);
            m3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k3.setTag("4");
                    i3.setTag("12");
                }
            }, 10);
        }
        if ("4".equals(k3.getTag())) {
            n3.setImageResource(R.drawable.redsuqare);
            n3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k3.setTag("5");
                    i3.setTag("13");
                }
            }, 10);

        }
        if ("5".equals(k3.getTag())) {
            o3.setImageResource(R.drawable.redsuqare);
            o3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k3.setTag("6");
                    i3.setTag("14");
                }
            }, 10);
        }
        if ("6".equals(k3.getTag())) {
            p3.setImageResource(R.drawable.redsuqare);
            p3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k3.setTag("7");
                    i3.setTag("15");
                }
            }, 10);

        }
        if ("7".equals(k3.getTag())) {
            q3.setImageResource(R.drawable.redsuqare);
            q3.postDelayed(new Runnable() {
                @Override
                public void run() {

                    i3.setTag("16");
                }
            }, 10);
        }


    }







     public void frontfader(){
         if ("1".equals(i2.getTag())) {
             i2.setImageResource(R.drawable.redsuqare);
             i2.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i2.setTag("2");
                     k2.setTag("10");
                 }
             }, 10);
         }
         if ("2".equals(i2.getTag())) {
             h2.setImageResource(R.drawable.redsuqare);
             h2.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i2.setTag("3");
                     k2.setTag("11");
                 }
             }, 10);

         }
         if ("3".equals(i2.getTag())) {
             g2.setImageResource(R.drawable.redsuqare);
             g2.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i2.setTag("4");
                     k2.setTag("12");
                 }
             }, 10);
         }
         if ("4".equals(i2.getTag())) {
             f2.setImageResource(R.drawable.redsuqare);
             f2.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i2.setTag("5");
                     k2.setTag("13");
                 }
             }, 10);

         }
         if ("5".equals(i2.getTag())) {
             e2.setImageResource(R.drawable.redsuqare);
             e2.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i2.setTag("6");
                     k2.setTag("14");
                 }
             }, 10);
         }
         if ("6".equals(i2.getTag())) {
             d2.setImageResource(R.drawable.redsuqare);
             d2.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i2.setTag("7");
                     k2.setTag("15");

                 }
             }, 10);

         }
         if ("7".equals(i2.getTag())) {
             c2.setImageResource(R.drawable.redsuqare);
             c2.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i2.setTag("8");
                     k2.setTag("16");
                 }
             }, 10);
         }
         if ("8".equals(i2.getTag())) {
             b2.setImageResource(R.drawable.redsuqare);
             b2.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i2.setTag("9");
                     k2.setTag("17");
                 }
             }, 10);

         }
         if ("9".equals(i2.getTag())) {
             a2.setImageResource(R.drawable.redsuqare);
             a2.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     k2.setTag("18");

                 }
             }, 10);

         }


         if ("10".equals(i2.getTag())) {
             k2.setImageResource(R.drawable.wihtesquare);
             k2.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i2.setTag("1");
                     k2.setTag("1");

                 }
             }, 10);
         }
         if ("11".equals(i2.getTag())) {
             l2.setImageResource(R.drawable.wihtesquare);
             l2.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i2.setTag("10");
                     k2.setTag("2");

                 }
             }, 10);
         }
         if ("12".equals(i2.getTag())) {
             m2.setImageResource(R.drawable.wihtesquare);
             m2.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i2.setTag("11");
                     k2.setTag("3");
                 }
             }, 10);
         }
         if ("13".equals(i2.getTag())) {
             n2.setImageResource(R.drawable.wihtesquare);
             n2.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i2.setTag("12");
                     k2.setTag("4");
                 }
             }, 10);

         }
         if ("14".equals(i2.getTag())) {
             o2.setImageResource(R.drawable.wihtesquare);
             o2.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i2.setTag("13");
                     k2.setTag("5");
                 }
             }, 10);
         }
         if ("15".equals(i2.getTag())) {
             p2.setImageResource(R.drawable.wihtesquare);
             p2.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i2.setTag("14");
                     k2.setTag("6");

                 }
             }, 10);

         }
         if ("16".equals(i2.getTag())) {
             q2.setImageResource(R.drawable.wihtesquare);
             q2.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i2.setTag("15");
                     k2.setTag("7");
                 }
             }, 10);
         }
         if ("17".equals(i2.getTag())) {
             r2.setImageResource(R.drawable.wihtesquare);
             r2.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i2.setTag("16");
                     k2.setTag("8");

                 }
             }, 10);

         }
         if ("18".equals(i2.getTag())) {
             s2.setImageResource(R.drawable.wihtesquare);
             s2.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     i2.setTag("17");
                     k2.setTag("9");
                 }
             }, 10);
         }

     }
    public void rearfader(){
        if ("18".equals(k2.getTag())) {
            a2.setImageResource(R.drawable.wihtesquare);
            a2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k2.setTag("17");
                    i2.setTag("9");
                }
            }, 10);
        }

        if ("17".equals(k2.getTag())) {
            b2.setImageResource(R.drawable.wihtesquare);
            b2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k2.setTag("16");
                    i2.setTag("8");

                }
            }, 10);
        }
        if ("16".equals(k2.getTag())) {
            c2.setImageResource(R.drawable.wihtesquare);
            c2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k2.setTag("15");
                    i2.setTag("7");
                }
            }, 10);
        }
        if ("15".equals(k2.getTag())) {
            d2.setImageResource(R.drawable.wihtesquare);
            d2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k2.setTag("14");
                    i2.setTag("6");
                }
            }, 10);

        }
        if ("14".equals(k2.getTag())) {
            e2.setImageResource(R.drawable.wihtesquare);
            e2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k2.setTag("13");
                    i2.setTag("5");
                }
            }, 10);
        }
        if ("13".equals(k2.getTag())) {
            f2.setImageResource(R.drawable.wihtesquare);
            f2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k2.setTag("12");
                    i2.setTag("4");
                }
            }, 10);

        }
        if ("12".equals(k2.getTag())) {
            g2.setImageResource(R.drawable.wihtesquare);
            g2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k2.setTag("11");
                    i2.setTag("3");
                }
            }, 10);
        }
        if ("11".equals(k2.getTag())) {
            h2.setImageResource(R.drawable.wihtesquare);
            h2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k2.setTag("10");
                    i2.setTag("2");
                }
            }, 10);

        }
        if ("10".equals(k2.getTag())) {
            i2.setImageResource(R.drawable.wihtesquare);
            i2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k2.setTag("1");
                    i2.setTag("1");

                }
            }, 10);
        }
        if ("1".equals(k2.getTag())) {
            k2.setImageResource(R.drawable.redsuqare);
            k2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k2.setTag("2");
                    i2.setTag("10");

                }
            }, 10);
        }
        if ("2".equals(k2.getTag())) {
            l2.setImageResource(R.drawable.redsuqare);
            l2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k2.setTag("3");
                    i2.setTag("11");
                }
            }, 10);
        }
        if ("3".equals(k2.getTag())) {
            m2.setImageResource(R.drawable.redsuqare);
            m2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k2.setTag("4");
                    i2.setTag("12");
                }
            }, 10);
        }
        if ("4".equals(k2.getTag())) {
            n2.setImageResource(R.drawable.redsuqare);
            n2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k2.setTag("5");
                    i2.setTag("13");
                }
            }, 10);

        }
        if ("5".equals(k2.getTag())) {
            o2.setImageResource(R.drawable.redsuqare);
            o2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k2.setTag("6");
                    i2.setTag("14");
                }
            }, 10);
        }
        if ("6".equals(k2.getTag())) {
            p2.setImageResource(R.drawable.redsuqare);
            p2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k2.setTag("7");
                    i2.setTag("15");
                }
            }, 10);

        }
        if ("7".equals(k2.getTag())) {
            q2.setImageResource(R.drawable.redsuqare);
            q2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k2.setTag("8");
                    i2.setTag("16");
                }
            }, 10);
        }
        if ("8".equals(k2.getTag())) {
            r2.setImageResource(R.drawable.redsuqare);
            r2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k2.setTag("9");
                    i2.setTag("17");
                }
            }, 10);

        }
        if ("9".equals(k2.getTag())) {
            s2.setImageResource(R.drawable.redsuqare);
            s2.postDelayed(new Runnable() {
                @Override
                public void run() {

                    i2.setTag("18");
                }
            }, 10);

        }
    }
    public void balanceL() {
        if ("1".equals(i1.getTag())) {
            i1.setImageResource(R.drawable.redsuqare);
            i1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i1.setTag("2");
                    k1.setTag("10");
                }
            }, 10);
        }
        if ("2".equals(i1.getTag())) {
            h1.setImageResource(R.drawable.redsuqare);
            h1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i1.setTag("3");
                    k1.setTag("11");
                }
            }, 10);

        }
        if ("3".equals(i1.getTag())) {
            g1.setImageResource(R.drawable.redsuqare);
            g1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i1.setTag("4");
                    k1.setTag("12");
                }
            }, 10);
        }
        if ("4".equals(i1.getTag())) {
            f1.setImageResource(R.drawable.redsuqare);
            f1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i1.setTag("5");
                    k1.setTag("13");
                }
            }, 10);

        }
        if ("5".equals(i1.getTag())) {
            e1.setImageResource(R.drawable.redsuqare);
            e1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i1.setTag("6");
                    k1.setTag("14");
                }
            }, 10);
        }
        if ("6".equals(i1.getTag())) {
            d1.setImageResource(R.drawable.redsuqare);
            d1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i1.setTag("7");
                    k1.setTag("15");

                }
            }, 10);

        }
        if ("7".equals(i1.getTag())) {
            c1.setImageResource(R.drawable.redsuqare);
            c1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i1.setTag("8");
                    k1.setTag("16");
                }
            }, 10);
        }
        if ("8".equals(i1.getTag())) {
            b1.setImageResource(R.drawable.redsuqare);
            b1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i1.setTag("9");
                    k1.setTag("17");
                }
            }, 10);

        }
        if ("9".equals(i1.getTag())) {
            a1.setImageResource(R.drawable.redsuqare);
            a1.postDelayed(new Runnable() {
                @Override
                public void run() {
                                    k1.setTag("18");

                }
            }, 10);

        }


        if ("10".equals(i1.getTag())) {
            k1.setImageResource(R.drawable.wihtesquare);
            k1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i1.setTag("1");
                    k1.setTag("1");

                }
            }, 10);
        }
        if ("11".equals(i1.getTag())) {
            l1.setImageResource(R.drawable.wihtesquare);
            l1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i1.setTag("10");
                    k1.setTag("2");

                }
            }, 10);
        }
        if ("12".equals(i1.getTag())) {
            m1.setImageResource(R.drawable.wihtesquare);
            m1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i1.setTag("11");
                    k1.setTag("3");
                }
            }, 10);
        }
        if ("13".equals(i1.getTag())) {
            n1.setImageResource(R.drawable.wihtesquare);
            n1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i1.setTag("12");
                    k1.setTag("4");
                }
            }, 10);

        }
        if ("14".equals(i1.getTag())) {
            o1.setImageResource(R.drawable.wihtesquare);
            o1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i1.setTag("13");
                    k1.setTag("5");
                }
            }, 10);
        }
        if ("15".equals(i1.getTag())) {
            p1.setImageResource(R.drawable.wihtesquare);
            p1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i1.setTag("14");
                    k1.setTag("6");

                }
            }, 10);

        }
        if ("16".equals(i1.getTag())) {
            q1.setImageResource(R.drawable.wihtesquare);
            q1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i1.setTag("15");
                    k1.setTag("7");
                }
            }, 10);
        }
        if ("17".equals(i1.getTag())) {
            r1.setImageResource(R.drawable.wihtesquare);
            r1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    i1.setTag("16");
                    k1.setTag("8");

                }
            }, 10);

        }
        if ("18".equals(i1.getTag())) {
            s1.setImageResource(R.drawable.wihtesquare);
            s1.postDelayed(new Runnable() {
                @Override
                public void run() {
                     i1.setTag("17");
                    k1.setTag("9");
                }
            }, 10);
        }

    }
    public void balanceR() {
        if ("18".equals(k1.getTag())) {
            a1.setImageResource(R.drawable.wihtesquare);
            a1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k1.setTag("17");
                    i1.setTag("9");
                }
            }, 10);
        }

        if ("17".equals(k1.getTag())) {
            b1.setImageResource(R.drawable.wihtesquare);
            b1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k1.setTag("16");
                    i1.setTag("8");

                }
            }, 10);
        }
        if ("16".equals(k1.getTag())) {
            c1.setImageResource(R.drawable.wihtesquare);
            c1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k1.setTag("15");
                    i1.setTag("7");
                }
            }, 10);
        }
        if ("15".equals(k1.getTag())) {
            d1.setImageResource(R.drawable.wihtesquare);
            d1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k1.setTag("14");
                    i1.setTag("6");
                }
            }, 10);

        }
        if ("14".equals(k1.getTag())) {
            e1.setImageResource(R.drawable.wihtesquare);
            e1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k1.setTag("13");
                    i1.setTag("5");
                }
            }, 10);
        }
        if ("13".equals(k1.getTag())) {
            f1.setImageResource(R.drawable.wihtesquare);
            f1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k1.setTag("12");
                    i1.setTag("4");
                }
            }, 10);

        }
        if ("12".equals(k1.getTag())) {
            g1.setImageResource(R.drawable.wihtesquare);
            g1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k1.setTag("11");
                    i1.setTag("3");
                }
            }, 10);
        }
        if ("11".equals(k1.getTag())) {
            h1.setImageResource(R.drawable.wihtesquare);
            h1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k1.setTag("10");
                    i1.setTag("2");
                }
            }, 10);

        }
        if ("10".equals(k1.getTag())) {
            i1.setImageResource(R.drawable.wihtesquare);
            i1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k1.setTag("1");
                    i1.setTag("1");

                }
            }, 10);
        }
        if ("1".equals(k1.getTag())) {
            k1.setImageResource(R.drawable.redsuqare);
            k1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k1.setTag("2");
                    i1.setTag("10");

                }
            }, 10);
        }
        if ("2".equals(k1.getTag())) {
            l1.setImageResource(R.drawable.redsuqare);
            l1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k1.setTag("3");
                    i1.setTag("11");
                }
            }, 10);
        }
        if ("3".equals(k1.getTag())) {
            m1.setImageResource(R.drawable.redsuqare);
            m1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k1.setTag("4");
                    i1.setTag("12");
                }
            }, 10);
        }
        if ("4".equals(k1.getTag())) {
            n1.setImageResource(R.drawable.redsuqare);
            n1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k1.setTag("5");
                    i1.setTag("13");
                }
            }, 10);

        }
        if ("5".equals(k1.getTag())) {
            o1.setImageResource(R.drawable.redsuqare);
            o1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k1.setTag("6");
                    i1.setTag("14");
                }
            }, 10);
        }
        if ("6".equals(k1.getTag())) {
            p1.setImageResource(R.drawable.redsuqare);
            p1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k1.setTag("7");
                    i1.setTag("15");
                }
            }, 10);

        }
        if ("7".equals(k1.getTag())) {
            q1.setImageResource(R.drawable.redsuqare);
            q1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k1.setTag("8");
                    i1.setTag("16");
                }
            }, 10);
        }
        if ("8".equals(k1.getTag())) {
            r1.setImageResource(R.drawable.redsuqare);
            r1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    k1.setTag("9");
                    i1.setTag("17");
                }
            }, 10);

        }
        if ("9".equals(k1.getTag())) {
            s1.setImageResource(R.drawable.redsuqare);
            s1.postDelayed(new Runnable() {
                @Override
                public void run() {

                    i1.setTag("18");
                }
            }, 10);

        }
    }



    public void Voulumeup() {

        if ("1".equals(a.getTag())) {
            a.setImageResource(R.drawable.redsuqare);
            a.postDelayed(new Runnable() {
                @Override
                public void run() {
                    a.setTag("2");
                    u.setTag("1");
                }
            }, 10);
        }
        if ("2".equals(a.getTag())) {
            b.setImageResource(R.drawable.redsuqare);
            b.postDelayed(new Runnable() {
                @Override
                public void run() {
                    a.setTag("3");
                    u.setTag("2");
                }
            }, 10);
        }
        if ("3".equals(a.getTag())) {
            c.setImageResource(R.drawable.redsuqare);
            c.postDelayed(new Runnable() {
                @Override
                public void run() {
                    a.setTag("4");
                    u.setTag("3");
                }
            }, 10);
        }
        if ("4".equals(a.getTag())) {
            d.setImageResource(R.drawable.redsuqare);
            d.postDelayed(new Runnable() {
                @Override
                public void run() {
                    a.setTag("5");
                    u.setTag("4");
                }
            }, 10);
        }
        if ("5".equals(a.getTag())) {
            e.setImageResource(R.drawable.redsuqare);
            e.postDelayed(new Runnable() {
                @Override
                public void run() {
                    a.setTag("6");
                    u.setTag("5");
                }
            }, 10);
        }
        if ("6".equals(a.getTag())) {
            f.setImageResource(R.drawable.redsuqare);
            f.postDelayed(new Runnable() {
                @Override
                public void run() {
                    a.setTag("7");
                    u.setTag("6");
                }
            }, 10);
        }
        if ("7".equals(a.getTag())) {
            g.setImageResource(R.drawable.redsuqare);
            g.postDelayed(new Runnable() {
                @Override
                public void run() {
                    a.setTag("8");
                    u.setTag("7");
                }
            }, 10);
        }
        if ("8".equals(a.getTag())) {
            h.setImageResource(R.drawable.redsuqare);
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    a.setTag("9");
                    u.setTag("8");
                }
            }, 10);
        }
        if ("9".equals(a.getTag())) {
            i.setImageResource(R.drawable.redsuqare);
            i.postDelayed(new Runnable() {
                @Override
                public void run() {
                    a.setTag("10");
                    u.setTag("9");
                }
            }, 10);
        }
        if ("10".equals(a.getTag())) {
            j.setImageResource(R.drawable.redsuqare);
            j.postDelayed(new Runnable() {
                @Override
                public void run() {
                    a.setTag("11");
                    u.setTag("10");
                }
            }, 10);
        }
        if ("11".equals(a.getTag())) {
            k.setImageResource(R.drawable.redsuqare);
            k.postDelayed(new Runnable() {
                @Override
                public void run() {
                    a.setTag("12");
                    u.setTag("11");
                }
            }, 10);
        }
        if ("12".equals(a.getTag())) {
            l.setImageResource(R.drawable.redsuqare);
            l.postDelayed(new Runnable() {
                @Override
                public void run() {
                    a.setTag("13");
                    u.setTag("12");
                }
            }, 10);
        }
        if ("13".equals(a.getTag())) {
            m.setImageResource(R.drawable.redsuqare);
            m.postDelayed(new Runnable() {
                @Override
                public void run() {

                    u.setTag("13");
                    a.setTag("14");
                }
            }, 10);
        }
        if ("14".equals(a.getTag())) {
            n.setImageResource(R.drawable.redsuqare);
            n.postDelayed(new Runnable() {
                @Override
                public void run() {

                    u.setTag("14");
                    a.setTag("15");
                }
            }, 10);
        }
        if ("15".equals(a.getTag())) {
            o.setImageResource(R.drawable.redsuqare);
            o.postDelayed(new Runnable() {
                @Override
                public void run() {

                    u.setTag("15");
                    a.setTag("16");
                }
            }, 10);
        }
        if ("16".equals(a.getTag())) {
            p.setImageResource(R.drawable.redsuqare);
            p.postDelayed(new Runnable() {
                @Override
                public void run() {
                    u.setTag("16");
                    a.setTag("17");
                }
            }, 10);
        }
        if ("17".equals(a.getTag())) {
            q.setImageResource(R.drawable.redsuqare);
            q.postDelayed(new Runnable() {
                @Override
                public void run() {

                    u.setTag("17");
                    a.setTag("18");
                }
            }, 10);
        }
        if ("18".equals(a.getTag())) {
            r.setImageResource(R.drawable.redsuqare);
            r.postDelayed(new Runnable() {
                @Override
                public void run() {
                    a.setTag("19");
                    u.setTag("18");
                }
            }, 10);
        }
        if ("19".equals(a.getTag())) {
            s.setImageResource(R.drawable.redsuqare);
            s.postDelayed(new Runnable() {
                @Override
                public void run() {
                    u.setTag("19");
                    a.setTag("20");
                }
            }, 10);
        }
        if ("20".equals(a.getTag())) {
            t.setImageResource(R.drawable.redsuqare);
            t.postDelayed(new Runnable() {
                @Override
                public void run() {
                    a.setTag("21");
                    u.setTag("20");
                }
            }, 10);
        }
        if ("21".equals(a.getTag())) {
            u.setImageResource(R.drawable.redsuqare);
            u.postDelayed(new Runnable() {
                @Override
                public void run() {

                    u.setTag("21");
                }
            }, 10);
        }
    }
        public void VolumeDown(){

            if ("1".equals(u.getTag())) {
                a.setImageResource(R.drawable.wihtesquare);
                a.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        a.setTag("1");
                    }
                }, 10);
            }
            if ("2".equals(u.getTag())) {
                b.setImageResource(R.drawable.wihtesquare);
                b.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        u.setTag("1");
                        a.setTag("2");
                    }
                }, 10);
            }
            if ("3".equals(u.getTag())) {
                c.setImageResource(R.drawable.wihtesquare);
                c.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        u.setTag("2");
                        a.setTag("3");
                    }
                }, 10);
            }
            if ("4".equals(u.getTag())) {
                d.setImageResource(R.drawable.wihtesquare);
                d.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        u.setTag("3");
                        a.setTag("4");
                    }
                }, 10);
            }
            if ("5".equals(u.getTag())) {
                e.setImageResource(R.drawable.wihtesquare);
                e.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        u.setTag("4");
                        a.setTag("5");
                    }
                }, 10);
            }
            if ("6".equals(u.getTag())) {
                f.setImageResource(R.drawable.wihtesquare);
                f.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        u.setTag("5");
                        a.setTag("6");
                    }
                }, 10);
            }
            if ("7".equals(u.getTag())) {
                g.setImageResource(R.drawable.wihtesquare);
                g.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        u.setTag("6");
                        a.setTag("7");
                    }
                }, 10);
            }
            if ("8".equals(u.getTag())) {
                h.setImageResource(R.drawable.wihtesquare);
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        u.setTag("7");
                        a.setTag("8");
                    }
                }, 10);
            }
            if ("9".equals(u.getTag())) {
                i.setImageResource(R.drawable.wihtesquare);
                i.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        u.setTag("8");
                        a.setTag("9");
                    }
                }, 10);
            }
            if ("10".equals(u.getTag())) {
                j.setImageResource(R.drawable.wihtesquare);
                j.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        u.setTag("9");
                        a.setTag("10");
                    }
                }, 10);
            }
            if ("11".equals(u.getTag())) {
                k.setImageResource(R.drawable.wihtesquare);
                k.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        u.setTag("10");
                        a.setTag("11");
                    }
                }, 10);
            }
            if ("12".equals(u.getTag())) {
                l.setImageResource(R.drawable.wihtesquare);
                l.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        u.setTag("11");
                        a.setTag("12");
                    }
                }, 10);
            }
            if ("13".equals(u.getTag())) {
                m.setImageResource(R.drawable.wihtesquare);
                m.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        u.setTag("12");
                        a.setTag("13");
                    }
                }, 10);
            }
            if ("14".equals(u.getTag())) {
                n.setImageResource(R.drawable.wihtesquare);
                n.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        u.setTag("13");
                        a.setTag("14");
                    }
                }, 10);
            }
            if ("15".equals(u.getTag())) {
                o.setImageResource(R.drawable.wihtesquare);
                o.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        u.setTag("14");
                        a.setTag("15");
                    }
                }, 10);
            }
            if ("16".equals(u.getTag())) {
                p.setImageResource(R.drawable.wihtesquare);
                p.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        u.setTag("15");
                        a.setTag("16");
                    }
                }, 10);
            }
            if ("17".equals(u.getTag())) {
                q.setImageResource(R.drawable.wihtesquare);
                q.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        u.setTag("16");
                        a.setTag("17");
                    }
                }, 10);
            }
            if ("18".equals(u.getTag())) {
                r.setImageResource(R.drawable.wihtesquare);
                r.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        u.setTag("17");
                        a.setTag("18");
                    }
                }, 10);
            }
            if ("19".equals(u.getTag())) {
                s.setImageResource(R.drawable.wihtesquare);
                s.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        u.setTag("18");
                        a.setTag("19");
                    }
                }, 10);
            }
            if ("20".equals(u.getTag())) {
                t.setImageResource(R.drawable.wihtesquare);
                t.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        u.setTag("19");
                        a.setTag("20");
                    }
                }, 10);
            }
            if ("21".equals(u.getTag())) {
                u.setImageResource(R.drawable.wihtesquare);
                u.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        a.setTag("21");
                        u.setTag("20");
                    }
                }, 10);
            }
    }
    }




