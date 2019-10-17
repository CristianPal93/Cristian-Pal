package com.cristianpal.seatibizacenter;


import android.app.Activity;

import android.app.AlertDialog;
import android.app.Application;
import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;

import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.ref.WeakReference;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import static android.R.attr.action;
import static android.R.attr.gestureStrokeType;
import static android.R.attr.name;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static android.view.View.getDefaultSize;

import android.os.Handler;



/**
 * Created by Cristian Pal on 7/21/2016.
 */
public class Home extends Activity {

    public static final String CMDPAUSE = "pause";
    public static final String SERVICECMD = "com.android.music.musicservicecommand";
    public static final String CMDNAME = "command";
    public static final String CMDPLAY = "play";
    PlugInControlReceiver mplug;
    TextView display;
    FloatingWindow mFloatingWindow;
    boolean mBounded;
    boolean mBounded1;
    boolean isCounterRunning = false;
    SoundControlService mcontrolservice;
    AppWidgetManager mAppWidgetManager;
    AppWidgetHost mAppWidgetHost;
    static final String TAG = "home";
    TextView mdate;
    TextView mtime;
    TextView msec;
    RelativeLayout standby;
    GridLayout grindview;
    ViewGroup mainlayout;
    ImageButton addwidget;
    ImageButton removewidget;
    ImageButton musicplayer;
    ImageButton filemanager;
    ImageButton navigator;
    ImageButton radio;
    ImageButton settings;
    ImageButton youtube;
    ImageButton internet;
    ImageButton calculator;
    ImageButton calendar;
    ImageButton downloads;
    ImageButton galery;
    ImageButton videos;
    RelativeLayout mrelative;
    RelativeLayout mrelative1;
    LinearLayout liniar;
    ViewGroup mView1;
    ViewGroup mView2;
    ImageButton apps;
    ImageButton climate;
    Button Loud;
    Button Bass;
    Button Treble;
    Button Balance;
    Button Fader;
    private UsbService usbService;
    static TextView bar1;
    static TextView bar2;
    static TextView bar3;
    static TextView bar4;
    static TextView bar5;
    static TextView bar6;
    static TextView text;
    static ImageView fan;
    static TextView off;
    static TextView value1;
    static TextView symb1;
    static TextView symb;
    static ImageView recicle;
    static TextView auto;
    static TextView ac;
    static TextView sybm2;
    static TextView louder;
    CountDownTimer cTimer = null;
    InputSelect[] _inputs;

    public static int count = 0;

    private MyHandler mHandler;

    private final BroadcastReceiver mUsbReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case UsbService.ACTION_USB_PERMISSION_GRANTED: // USB PERMISSION GRANTED
                    Toast.makeText(context, "USB Ready", Toast.LENGTH_SHORT).show();
                    break;
                case UsbService.ACTION_USB_PERMISSION_NOT_GRANTED: // USB PERMISSION NOT GRANTED
                    Toast.makeText(context, "USB Permission not granted", Toast.LENGTH_SHORT).show();
                    break;
                case UsbService.ACTION_NO_USB: // NO USB CONNECTED
                    Toast.makeText(context, "No USB connected", Toast.LENGTH_SHORT).show();
                    break;
                case UsbService.ACTION_USB_DISCONNECTED:// USB DISCONNECTED

                    Toast.makeText(context, "USB disconnected", Toast.LENGTH_SHORT).show();
                    break;
                case UsbService.ACTION_USB_NOT_SUPPORTED: // USB NOT SUPPORTED
                    Toast.makeText(context, "USB device not supported", Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    };

    private final ServiceConnection usbConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName arg0, IBinder arg1) {
            usbService = ((UsbService.UsbBinder) arg1).getService();
            usbService.setHandler(mHandler);
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            usbService = null;
        }
    };


    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.home);
        super.onCreate(savedInstanceState);

        {
            loadInputs();
            IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
            filter.addAction(Intent.ACTION_SCREEN_OFF);
            BroadcastReceiver mReceiver = new PlugInControlReceiver();
            registerReceiver(mReceiver, filter);
            mdate = (TextView) findViewById(R.id.textView17);
            mtime = (TextView) findViewById(R.id.textView16);
            msec = (TextView) findViewById(R.id.textView18);
            grindview = (GridLayout) findViewById(R.id.grind);
            mHandler = new MyHandler(this);
            standby = (RelativeLayout) findViewById(R.id.standby1);
            mrelative = (RelativeLayout) findViewById(R.id.mrelative);
            mrelative1 = (RelativeLayout) findViewById(R.id.relative1);
            liniar = (LinearLayout) findViewById(R.id.main_layout);
            mView1 = (ViewGroup) findViewById(R.id.view1);
            mView2 = (ViewGroup) findViewById(R.id.view2);
            climate = (ImageButton) findViewById(R.id.imageButton3);
            apps = (ImageButton) findViewById(R.id.imageButton4);
            addwidget = (ImageButton) findViewById(R.id.imageButton);
            removewidget = (ImageButton) findViewById(R.id.imageButton2);
            musicplayer = (ImageButton) findViewById(R.id.imageButton14);
            filemanager = (ImageButton) findViewById(R.id.imageButton12);
            navigator = (ImageButton) findViewById(R.id.imageButton17);
            radio = (ImageButton) findViewById(R.id.imageButton16);
            settings = (ImageButton) findViewById(R.id.imageButton15);
            youtube = (ImageButton) findViewById(R.id.imageButton18);
            internet = (ImageButton) findViewById(R.id.imageButton19);
            calculator = (ImageButton) findViewById(R.id.imageButton20);
            calendar = (ImageButton) findViewById(R.id.imageButton21);
            downloads = (ImageButton) findViewById(R.id.imageButton23);
            galery = (ImageButton) findViewById(R.id.imageButton24);
            videos = (ImageButton) findViewById(R.id.imageButton30);
            Loud = (Button) findViewById(R.id.button5);
            Bass = (Button) findViewById(R.id.button1);
            Treble = (Button) findViewById(R.id.button2);
            Balance = (Button) findViewById(R.id.button3);
            Fader = (Button) findViewById(R.id.button4);
            mAppWidgetManager = AppWidgetManager.getInstance(this);
            mAppWidgetHost = new AppWidgetHost(this, R.id.APPWIDGET_HOST_ID);
            mainlayout = (ViewGroup) findViewById(R.id.main_layout);
            display = (TextView) findViewById(R.id.textView12);
            bar1 = (TextView) findViewById(R.id.bar1);
            bar2 = (TextView) findViewById(R.id.bar2);
            bar3 = (TextView) findViewById(R.id.bar3);
            bar4 = (TextView) findViewById(R.id.bar4);
            bar5 = (TextView) findViewById(R.id.bar5);
            bar6 = (TextView) findViewById(R.id.bar6);
            text = (TextView) findViewById(R.id.textView6);
            fan = (ImageView) findViewById(R.id.fan);
            off = (TextView) findViewById(R.id.OFF);
            value1 = (TextView) findViewById(R.id.temp);
            symb1 = (TextView) findViewById(R.id.textView9);
            symb = (TextView) findViewById(R.id.textView13);
            recicle = (ImageView) findViewById(R.id.imageView6);
            auto = (TextView) findViewById(R.id.auto);
            ac = (TextView) findViewById(R.id.ac);
            sybm2 = (TextView) findViewById(R.id.textView14);
            StartTimer();
            louder = (TextView) findViewById(R.id.loud);

            Thread t = new Thread() {

                @Override
                public void run() {
                    try {
                        while (!isInterrupted()) {
                            Thread.sleep(1000);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    updatetextview();
                                }
                            });
                        }
                    } catch (InterruptedException e) {
                    }
                }
            };

            t.start();

            Loud.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    usbService.write("K".getBytes());
                }
            });
            Bass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    usbService.write("P".getBytes());
                }
            });
            Treble.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    usbService.write("O".getBytes());
                }
            });
            Balance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    usbService.write("T".getBytes());
                }
            });
            Fader.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    usbService.write("H".getBytes());
                }
            });
            Bass.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    usbService.write("J".getBytes());
                    mcontrolservice.view4();
                    mcontrolservice.resetbass();
                    resetTime();
                    return true;
                }
            });
            Treble.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    usbService.write("G".getBytes());
                    mcontrolservice.view5();
                    mcontrolservice.resettreble();
                    resetTime();
                    return true;
                }
            });
            Fader.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    usbService.write("A".getBytes());
                    mcontrolservice.view3();
                    mcontrolservice.resetfader();
                    resetTime();
                    return true;
                }
            });
            Balance.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    usbService.write("L".getBytes());
                    mcontrolservice.view2();
                    mcontrolservice.resetbalance();
                    resetTime();

                    return true;
                }
            });

            addwidget.setOnTouchListener(new View.OnTouchListener() {


                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                            v.invalidate();
                            break;
                        }
                        case MotionEvent.ACTION_UP:

                            selectWidget();

                        case MotionEvent.ACTION_CANCEL: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().clearColorFilter();
                            view.invalidate();
                            break;
                        }
                    }
                    return true;
                }
            });
            removewidget.setOnTouchListener(new View.OnTouchListener() {


                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                            v.invalidate();
                            break;
                        }
                        case MotionEvent.ACTION_UP:

                            removeWidgetMenuSelected();

                        case MotionEvent.ACTION_CANCEL: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().clearColorFilter();
                            view.invalidate();
                            break;
                        }
                    }
                    return true;
                }
            });
            musicplayer.setOnTouchListener(new View.OnTouchListener() {


                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                            v.invalidate();
                            break;
                        }
                        case MotionEvent.ACTION_UP:
                            Intent intent = new Intent("android.intent.action.MUSIC_PLAYER");
                            startActivity(intent);

                        case MotionEvent.ACTION_CANCEL: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().clearColorFilter();
                            view.invalidate();
                            break;
                        }
                    }
                    return true;
                }
            });
            filemanager.setOnTouchListener(new View.OnTouchListener() {


                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                            v.invalidate();
                            break;
                        }
                        case MotionEvent.ACTION_UP:
                            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.mediatek.filemanager");
                            startActivity(launchIntent);

                        case MotionEvent.ACTION_CANCEL: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().clearColorFilter();
                            view.invalidate();
                            break;
                        }
                    }
                    return true;
                }
            });
            navigator.setOnTouchListener(new View.OnTouchListener() {


                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                            v.invalidate();
                            break;
                        }
                        case MotionEvent.ACTION_UP:
                            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.mapfactor.navigator");
                            startActivity(launchIntent);

                        case MotionEvent.ACTION_CANCEL: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().clearColorFilter();
                            view.invalidate();
                            break;
                        }
                    }
                    return true;
                }
            });
            radio.setOnTouchListener(new View.OnTouchListener() {


                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                            v.invalidate();
                            break;
                        }
                        case MotionEvent.ACTION_UP:
                            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.fmradio");
                            startActivity(launchIntent);

                        case MotionEvent.ACTION_CANCEL: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().clearColorFilter();
                            view.invalidate();
                            break;
                        }
                    }
                    return true;
                }
            });
            settings.setOnTouchListener(new View.OnTouchListener() {


                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                            v.invalidate();
                            break;
                        }
                        case MotionEvent.ACTION_UP:
                            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.settings");
                            startActivity(launchIntent);
                        case MotionEvent.ACTION_CANCEL: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().clearColorFilter();
                            view.invalidate();
                            break;
                        }
                    }
                    return true;
                }
            });
            youtube.setOnTouchListener(new View.OnTouchListener() {


                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                            v.invalidate();
                            break;
                        }
                        case MotionEvent.ACTION_UP:
                            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
                            startActivity(launchIntent);
                        case MotionEvent.ACTION_CANCEL: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().clearColorFilter();
                            view.invalidate();
                            break;
                        }
                    }
                    return true;
                }
            });
            internet.setOnTouchListener(new View.OnTouchListener() {


                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                            v.invalidate();
                            break;
                        }
                        case MotionEvent.ACTION_UP:
                            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.chrome");
                            startActivity(launchIntent);
                        case MotionEvent.ACTION_CANCEL: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().clearColorFilter();
                            view.invalidate();
                            break;
                        }
                    }
                    return true;
                }
            });
            calculator.setOnTouchListener(new View.OnTouchListener() {


                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                            v.invalidate();
                            break;
                        }
                        case MotionEvent.ACTION_UP:
                            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.calculator2");
                            startActivity(launchIntent);

                        case MotionEvent.ACTION_CANCEL: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().clearColorFilter();
                            view.invalidate();
                            break;
                        }
                    }
                    return true;
                }
            });
            calendar.setOnTouchListener(new View.OnTouchListener() {


                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                            v.invalidate();
                            break;
                        }
                        case MotionEvent.ACTION_UP:
                            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.calendar");
                            startActivity(launchIntent);

                        case MotionEvent.ACTION_CANCEL: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().clearColorFilter();
                            view.invalidate();
                            break;
                        }
                    }
                    return true;
                }
            });
            downloads.setOnTouchListener(new View.OnTouchListener() {


                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                            v.invalidate();
                            break;
                        }
                        case MotionEvent.ACTION_UP:
                            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.providers.downloads.ui");
                            startActivity(launchIntent);

                        case MotionEvent.ACTION_CANCEL: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().clearColorFilter();
                            view.invalidate();
                            break;
                        }
                    }
                    return true;
                }
            });
            galery.setOnTouchListener(new View.OnTouchListener() {


                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                            v.invalidate();
                            break;
                        }
                        case MotionEvent.ACTION_UP:
                            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.photos");
                            startActivity(launchIntent);

                        case MotionEvent.ACTION_CANCEL: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().clearColorFilter();
                            view.invalidate();
                            break;
                        }
                    }
                    return true;
                }
            });
            videos.setOnTouchListener(new View.OnTouchListener() {


                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                            v.invalidate();
                            break;
                        }
                        case MotionEvent.ACTION_UP:


                            handlePush(v);

                        case MotionEvent.ACTION_CANCEL: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().clearColorFilter();
                            view.invalidate();
                            break;
                        }
                    }
                    return true;
                }
            });
            apps.setOnTouchListener(new View.OnTouchListener() {


                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                            v.invalidate();
                            break;
                        }
                        case MotionEvent.ACTION_UP:
                            mView1.setVisibility(VISIBLE);
                            mView2.setVisibility(INVISIBLE);
                        case MotionEvent.ACTION_CANCEL: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().clearColorFilter();
                            view.invalidate();
                            break;
                        }
                    }
                    return true;
                }
            });
            climate.setOnTouchListener(new View.OnTouchListener() {


                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                            v.invalidate();
                            break;
                        }
                        case MotionEvent.ACTION_UP:
                            mView1.setVisibility(INVISIBLE);
                            mView2.setVisibility(VISIBLE);
                        case MotionEvent.ACTION_CANCEL: {
                            ImageButton view = (ImageButton) v;
                            view.getBackground().clearColorFilter();
                            view.invalidate();
                            break;
                        }
                    }
                    return true;
                }
            });
        }
    }



    private void loadInputs() {
        System.out.println("########## 1  ");
        _inputs = new InputSelect[3];

        // define the display string, the image, and the value to use
        // when the choice is selected
       _inputs[0]  = new InputSelect( "  Aux IN", getImg( R.drawable.auxin),"Aux" );
        _inputs[1]  = new InputSelect( "  Device", getImg( R.drawable.ic_launcher),"Device" );
        _inputs[2]  = new InputSelect( "  Wlan Audio", getImg( R.drawable.bubbleupnpicon),"Wlan Audio" );




    }
    private Drawable getImg( int res )
    {
        System.out.println("########## 3  ");
        Drawable img = getResources().getDrawable( res );
        img.setBounds( 0, 0, 48, 48 );
        return img;
    }


    public void handlePush( View target ) {
        System.out.println("##########  button clicked handle push");

        ListAdapter adapter = new InputSelector( this, _inputs );
        final AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setTitle("Audio input select");


        ad.setSingleChoiceItems( adapter, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // a choice has been made!
                String selectedVal = _inputs[which].getVal();
                Log.d(TAG, "chosen " + selectedVal );
                if(selectedVal.equals("Bluetooth")){
                    Toast.makeText(getApplication(),"Bluetooth selected",Toast.LENGTH_SHORT).show();
                    TextView text = (TextView)findViewById(R.id.textView19);
                    text.setText("   Audio source: Bluetooth ");
                    usbService.write("V".getBytes());
                    Toast.makeText(getApplication(),"Bluetooth Started",Toast.LENGTH_SHORT).show();
                    AudioManager mAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
                    if (mAudioManager.isMusicActive()) {
                        Intent i = new Intent(SERVICECMD);
                        i.putExtra(CMDNAME, CMDPAUSE);
                        Home.this.sendBroadcast(i);
                        usbService.write("Y".getBytes());
                    }

                }
                if(selectedVal.equals("Aux")){
                    Toast.makeText(getApplication(),"Aux selected",Toast.LENGTH_LONG).show();
                    TextView text = (TextView)findViewById(R.id.textView19);
                    text.setText("   Audio source: Aux ");
                    usbService.write("X".getBytes());
                    usbService.write("v".getBytes());
                    AudioManager mAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
                    if (mAudioManager.isMusicActive()) {
                        Intent i = new Intent(SERVICECMD);
                        i.putExtra(CMDNAME, CMDPAUSE);
                        Home.this.sendBroadcast(i);
                        usbService.write("Y".getBytes());
                    }


                }      if(selectedVal.equals("Wlan Audio")){
                    Toast.makeText(getApplication(),"Starting Wlan Audio",Toast.LENGTH_LONG).show();
                    Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.bubblesoft.android.bubbleupnp");
                    startActivity(launchIntent);
                    TextView text = (TextView)findViewById(R.id.textView19);
                    text.setText("   Audio source: Device ");
                    usbService.write("Y".getBytes());
                    usbService.write("v".getBytes());
                    AudioManager mAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
                    if (mAudioManager.isMusicActive()) {
                        Intent i = new Intent(SERVICECMD);
                        i.putExtra(CMDNAME, CMDPAUSE);
                        Home.this.sendBroadcast(i);
                        usbService.write("Y".getBytes());
                    }

                }    if(selectedVal.equals("Device")){
                    Toast.makeText(getApplication(),"Device selected",Toast.LENGTH_LONG).show();
                    TextView text = (TextView)findViewById(R.id.textView19);
                    text.setText("   Audio source: Device ");
                    AudioManager mAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
                    if (!mAudioManager.isMusicActive()) {
                        Intent i = new Intent(SERVICECMD);
                        i.putExtra(CMDNAME, CMDPLAY);
                        Home.this.sendBroadcast(i);
                        usbService.write("Y".getBytes());
                    }
                }
                dialog.dismiss();


            }

        });

        ad.show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) > 5
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            Log.d("CDA", "onKeyDown Called");
            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }



    @Override
    public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
        Intent setIntent = new Intent(Intent.ACTION_MAIN);
        setIntent.addCategory(Intent.CATEGORY_HOME);
        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(setIntent);
        mView2.setVisibility(INVISIBLE);
    }





    static class InputSelector extends ArrayAdapter<InputSelect> {

        private static final int RESOURCE = R.layout.inputselector;
        private LayoutInflater inflater;

        static class ViewHolder {
            CheckedTextView nameTxVw;
        }
        //@SuppressWarnings("unchecked")
        InputSelector(Context context, InputSelect[] objects)
        {
            super(context, RESOURCE, objects);
            inflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            count=count+1;
            System.out.println("################ "+count+" position  "+position+" parent "+parent);
            ViewHolder holder;
            System.out.println("##########  getview outside if 1 "+count);
            if ( convertView == null ) {
                System.out.println("##########  getview if 1 "+count);
                // inflate a new view and setup the view holder for future use
                convertView = inflater.inflate( RESOURCE, null );

                holder = new ViewHolder();
                holder.nameTxVw = (CheckedTextView) convertView.findViewById(R.id.miastorow_text);
                convertView.setTag( holder );
            }  else {
                System.out.println("##########  getview else 1 "+count+"  convert "+convertView.toString());
                // view already defined, retrieve view holder
                holder = (ViewHolder) convertView.getTag();
            }

            InputSelect device = (InputSelect) getItem( position );
            if ( device == null ) {
                System.out.println("##########  getview if 2");
                //Log.e( TAG, “Invalid category for position: ”+position);
            }
            holder.nameTxVw.setText( device.getName() );
            holder.nameTxVw.setCompoundDrawables( device.getImg(), null, null, null );
          holder.nameTxVw.setCheckMarkDrawable(null);


            return convertView;
        }
    }
    class InputSelect {
        private String   _name;
        private Drawable _img;
        private String   _val;

        public InputSelect( String name, Drawable img, String val ) {

            System.out.println("##########  2");
            _name = name;
            _img = img;
            _val = val;
        Toast.makeText(getApplicationContext(),val,Toast.LENGTH_LONG);
        }

        public String getName() {
            return _name;
        }

        public Drawable getImg() {
            return _img;
        }

        public String getVal() {
            return _val;
        }
    }






    public void resetTime() {
        if (!isCounterRunning) {
            isCounterRunning = true;
            cTimer.start();

        } else {

            cTimer.cancel();
            cTimer.start();

        }


    }

    @Override
    public void onResume() {
        super.onResume();
        setFilters();  // Start listening notifications from UsbService
        startService(UsbService.class, usbConnection, null);

        if (!PlugInControlReceiver.wasScreenOn) {

        } else {mrelative.setBackground(getResources().getDrawable(R.drawable.display));
            mView1.setVisibility(VISIBLE);
            mView2.setVisibility(INVISIBLE);
            liniar.setVisibility(VISIBLE);
            mrelative1.setVisibility(VISIBLE);

        }

        }

    public void updatetextview(){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("EEE, MMM d, ''yy");
        SimpleDateFormat tf = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sf = new SimpleDateFormat(":ss");
        String formattedDate = df.format(c.getTime());
        String formattedTime = tf.format(c.getTime());
        String formattedSec = sf.format(c.getTime());
        mdate.setText(formattedDate);
        mtime.setText(formattedTime);
        msec.setText(formattedSec);
    }



    @Override
    public void onPause() {
        super.onPause();
        unregisterReceiver(mUsbReceiver);
        unbindService(usbConnection);
        if (PlugInControlReceiver.wasScreenOn) {


        } else {
            mrelative.setBackground(getResources().getDrawable(R.drawable.blankscreen));
            mView1.setVisibility(INVISIBLE);
            liniar.setVisibility(INVISIBLE);
            mrelative1.setVisibility(INVISIBLE);
        }

    }

    private void startService(Class<?> service, ServiceConnection serviceConnection, Bundle extras) {
        if (!UsbService.SERVICE_CONNECTED) {
            Intent startService = new Intent(this, service);
            if (extras != null && !extras.isEmpty()) {
                Set<String> keys = extras.keySet();
                for (String key : keys) {
                    String extra = extras.getString(key);
                    startService.putExtra(key, extra);
                }
            }
            startService(startService);
        }
        Intent bindingIntent = new Intent(this, service);
        bindService(bindingIntent, serviceConnection, Context.BIND_AUTO_CREATE);
    }



    private void setFilters() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(UsbService.ACTION_USB_PERMISSION_GRANTED);
        filter.addAction(UsbService.ACTION_NO_USB);
        filter.addAction(UsbService.ACTION_USB_DISCONNECTED);
        filter.addAction(UsbService.ACTION_USB_NOT_SUPPORTED);
        filter.addAction(UsbService.ACTION_USB_PERMISSION_NOT_GRANTED);
        registerReceiver(mUsbReceiver, filter);
    }
    public  void StartTimer(){

        cTimer=new CountDownTimer(3000 ,300) {

            @Override
            public void onFinish () {
                System.out.println("Timer Completed.");

                //Spielt den TON ab, wenn die ZEit um ist. Siehe Methode playSound!

                isCounterRunning = false;
                mcontrolservice.delay();
                usbService.write("Q".getBytes());
            }

            @Override
            public void onTick ( long millisUntilFinished){


                SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
                // dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                Date date = new Date(millisUntilFinished);


                // System.out.println("Timer  : " + (millisUntilFinished/1000));
                System.out.println("Timer   : " + dateFormat.format(date));
            }
        };
    }

    /*
     * This handler will be passed to UsbService. Data received from serial port is displayed through this handler
     */
    private class MyHandler extends Handler {
        private final WeakReference<Home> mActivity;



        public MyHandler(Home activity) {
            mActivity = new WeakReference<>(activity);

        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UsbService.MESSAGE_FROM_SERIAL_PORT:
                    String data = (String) msg.obj;
                    mActivity.get().display.append(data);
                    break;
                case UsbService.CTS_CHANGE:
                    Toast.makeText(mActivity.get(), "CTS_CHANGE", Toast.LENGTH_LONG).show();
                    break;
                case UsbService.DSR_CHANGE:
                    Toast.makeText(mActivity.get(), "DSR_CHANGE", Toast.LENGTH_LONG).show();
                    break;
            }

            if (msg.obj.equals("a")) {
                ac.setVisibility(VISIBLE);
                Toast.makeText(mActivity.get(), "A/C on!", Toast.LENGTH_SHORT).show();


            }
            if (msg.obj.equals("c")) {

                ac.setVisibility(INVISIBLE);
                Toast.makeText(mActivity.get(), "A/C off!", Toast.LENGTH_SHORT).show();


            }
            if (msg.obj.equals("1"))

            {
                fan.setVisibility(VISIBLE);
                off.setVisibility(INVISIBLE);
                bar1.setVisibility(VISIBLE);
                bar2.setVisibility(INVISIBLE);
                bar3.setVisibility(INVISIBLE);
                bar4.setVisibility(INVISIBLE);
                bar5.setVisibility(INVISIBLE);
                bar6.setVisibility(INVISIBLE);
                auto.setVisibility(INVISIBLE);
                symb.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);


            }
            if (msg.obj.equals("2"))

            {
                fan.setVisibility(VISIBLE);
                off.setVisibility(INVISIBLE);
                bar1.setVisibility(VISIBLE);
                bar2.setVisibility(VISIBLE);
                bar3.setVisibility(INVISIBLE);
                bar4.setVisibility(INVISIBLE);
                bar5.setVisibility(INVISIBLE);
                bar6.setVisibility(INVISIBLE);
                auto.setVisibility(INVISIBLE);
                symb.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);

            }
            if (msg.obj.equals("3"))

            {
                fan.setVisibility(VISIBLE);
                off.setVisibility(INVISIBLE);
                bar1.setVisibility(VISIBLE);
                bar2.setVisibility(VISIBLE);
                bar3.setVisibility(VISIBLE);
                bar4.setVisibility(INVISIBLE);
                bar5.setVisibility(INVISIBLE);
                bar6.setVisibility(INVISIBLE);
                auto.setVisibility(INVISIBLE);
                symb.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);

            }
            if (msg.obj.equals("4"))

            {
                fan.setVisibility(VISIBLE);
                off.setVisibility(INVISIBLE);
                bar1.setVisibility(VISIBLE);
                bar2.setVisibility(VISIBLE);
                bar3.setVisibility(VISIBLE);
                bar4.setVisibility(VISIBLE);
                bar5.setVisibility(INVISIBLE);
                bar6.setVisibility(INVISIBLE);
                auto.setVisibility(INVISIBLE);
                symb.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);

            }
            if (msg.obj.equals("5"))

            {
                fan.setVisibility(VISIBLE);
                off.setVisibility(INVISIBLE);
                bar1.setVisibility(VISIBLE);
                bar2.setVisibility(VISIBLE);
                bar3.setVisibility(VISIBLE);
                bar4.setVisibility(VISIBLE);
                bar5.setVisibility(VISIBLE);
                bar6.setVisibility(INVISIBLE);
                auto.setVisibility(INVISIBLE);
                symb.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);

            }

            if (msg.obj.equals("6"))

            {
                fan.setVisibility(VISIBLE);
                off.setVisibility(INVISIBLE);
                bar1.setVisibility(VISIBLE);
                bar2.setVisibility(VISIBLE);
                bar3.setVisibility(VISIBLE);
                bar4.setVisibility(VISIBLE);
                bar5.setVisibility(VISIBLE);
                bar6.setVisibility(VISIBLE);
                auto.setVisibility(INVISIBLE);
                symb.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);

            }
            if (msg.obj.equals("0"))

            {
                fan.setVisibility(VISIBLE);
                off.setVisibility(VISIBLE);
                bar1.setVisibility(INVISIBLE);
                bar2.setVisibility(INVISIBLE);
                bar3.setVisibility(INVISIBLE);
                bar4.setVisibility(INVISIBLE);
                bar5.setVisibility(INVISIBLE);
                bar6.setVisibility(INVISIBLE);
                ac.setVisibility(INVISIBLE);
                recicle.setVisibility(INVISIBLE);
                auto.setVisibility(INVISIBLE);
                sybm2.setVisibility(INVISIBLE);
                symb.setVisibility(INVISIBLE);
                symb1.setVisibility(INVISIBLE);
                value1.setVisibility(INVISIBLE);

            }


            if (msg.obj.equals("e")) {

                symb.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);
                fan.setVisibility(VISIBLE);
                value1.setText("LO");
                if (off.getVisibility() == View.VISIBLE) {

                    bar1.setVisibility(VISIBLE);
                    bar2.setVisibility(INVISIBLE);
                    bar3.setVisibility(INVISIBLE);
                    bar4.setVisibility(INVISIBLE);
                    bar5.setVisibility(INVISIBLE);
                    bar6.setVisibility(INVISIBLE);
                }


            }
            if (msg.obj.equals("f")) {

                symb.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);
                fan.setVisibility(VISIBLE);
                value1.setText("18");

                if (off.getVisibility() == View.VISIBLE) {

                    bar1.setVisibility(VISIBLE);
                    bar2.setVisibility(INVISIBLE);
                    bar3.setVisibility(INVISIBLE);
                    bar4.setVisibility(INVISIBLE);
                    bar5.setVisibility(INVISIBLE);
                    bar6.setVisibility(INVISIBLE);
                }
            }

            if (msg.obj.equals("g")) {

                symb.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);
                fan.setVisibility(VISIBLE);
                value1.setText("19");

            }
            if (msg.obj.equals("h")) {

                symb.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);
                fan.setVisibility(VISIBLE);
                value1.setText("20");

                if (off.getVisibility() == View.VISIBLE) {
                    bar1.setVisibility(VISIBLE);
                    bar2.setVisibility(INVISIBLE);
                    bar3.setVisibility(INVISIBLE);
                    bar4.setVisibility(INVISIBLE);
                    bar5.setVisibility(INVISIBLE);
                    bar6.setVisibility(INVISIBLE);
                }
            }
            if (msg.obj.equals("i")) {

                symb.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);
                fan.setVisibility(VISIBLE);
                value1.setText("21");

                if (off.getVisibility() == View.VISIBLE) {

                    bar1.setVisibility(VISIBLE);
                    bar2.setVisibility(INVISIBLE);
                    bar3.setVisibility(INVISIBLE);
                    bar4.setVisibility(INVISIBLE);
                    bar5.setVisibility(INVISIBLE);
                    bar6.setVisibility(INVISIBLE);
                }
            }
            if (msg.obj.equals("j")) {

                symb.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);
                fan.setVisibility(VISIBLE);
                value1.setText("22");

                if (off.getVisibility() == View.VISIBLE) {
                    bar1.setVisibility(VISIBLE);
                    bar2.setVisibility(INVISIBLE);
                    bar3.setVisibility(INVISIBLE);
                    bar4.setVisibility(INVISIBLE);
                    bar5.setVisibility(INVISIBLE);
                    bar6.setVisibility(INVISIBLE);
                }
            }
            if (msg.obj.equals("k")) {

                symb.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);
                fan.setVisibility(VISIBLE);
                value1.setText("23");

                if (off.getVisibility() == View.VISIBLE) {

                    bar1.setVisibility(VISIBLE);
                    bar2.setVisibility(INVISIBLE);
                    bar3.setVisibility(INVISIBLE);
                    bar4.setVisibility(INVISIBLE);
                    bar5.setVisibility(INVISIBLE);
                    bar6.setVisibility(INVISIBLE);
                }
            }
            if (msg.obj.equals("l")) {

                symb.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);
                fan.setVisibility(VISIBLE);
                value1.setText("24");

                if (off.getVisibility() == View.VISIBLE) {

                    bar1.setVisibility(VISIBLE);
                    bar2.setVisibility(INVISIBLE);
                    bar3.setVisibility(INVISIBLE);
                    bar4.setVisibility(INVISIBLE);
                    bar5.setVisibility(INVISIBLE);
                    bar6.setVisibility(INVISIBLE);
                }
            }
            if (msg.obj.equals("m")) {

                symb.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);
                fan.setVisibility(VISIBLE);
                value1.setText("25");

                if (off.getVisibility() == View.VISIBLE) {

                    bar1.setVisibility(VISIBLE);
                    bar2.setVisibility(INVISIBLE);
                    bar3.setVisibility(INVISIBLE);
                    bar4.setVisibility(INVISIBLE);
                    bar5.setVisibility(INVISIBLE);
                    bar6.setVisibility(INVISIBLE);
                }
            }
            if (msg.obj.equals("n")) {

                symb.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);
                fan.setVisibility(VISIBLE);
                value1.setText("26");

                if (off.getVisibility() == View.VISIBLE) {

                    bar1.setVisibility(VISIBLE);
                    bar2.setVisibility(INVISIBLE);
                    bar3.setVisibility(INVISIBLE);
                    bar4.setVisibility(INVISIBLE);
                    bar5.setVisibility(INVISIBLE);
                    bar6.setVisibility(INVISIBLE);
                }
            }
            if (msg.obj.equals("o")) {

                symb.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);
                fan.setVisibility(VISIBLE);
                value1.setText("27");

                if (off.getVisibility() == View.VISIBLE) {

                    bar1.setVisibility(VISIBLE);
                    bar2.setVisibility(INVISIBLE);
                    bar3.setVisibility(INVISIBLE);
                    bar4.setVisibility(INVISIBLE);
                    bar5.setVisibility(INVISIBLE);
                    bar6.setVisibility(INVISIBLE);
                }
            }
            if (msg.obj.equals("p")) {

                symb.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);
                fan.setVisibility(VISIBLE);
                value1.setText("28");

                if (off.getVisibility() == View.VISIBLE) {

                    bar1.setVisibility(VISIBLE);
                    bar2.setVisibility(INVISIBLE);
                    bar3.setVisibility(INVISIBLE);
                    bar4.setVisibility(INVISIBLE);
                    bar5.setVisibility(INVISIBLE);
                    bar6.setVisibility(INVISIBLE);
                }
            }
            if (msg.obj.equals("q")) {

                symb.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);
                fan.setVisibility(VISIBLE);
                value1.setText("HI ");

                if (off.getVisibility() == View.VISIBLE) {

                    bar1.setVisibility(VISIBLE);
                    bar2.setVisibility(INVISIBLE);
                    bar3.setVisibility(INVISIBLE);
                    bar4.setVisibility(INVISIBLE);
                    bar5.setVisibility(INVISIBLE);
                    bar6.setVisibility(INVISIBLE);
                }
            }
            if (msg.obj.equals("y") && off.getVisibility() == View.INVISIBLE) {
                recicle.setVisibility(INVISIBLE);


            }
            if (msg.obj.equals("t") && off.getVisibility() == View.INVISIBLE) {
                recicle.setVisibility(VISIBLE);
                auto.setVisibility(INVISIBLE);

            }
            if (msg.obj.equals("u")) {
                auto.setVisibility(VISIBLE);
                recicle.setVisibility(INVISIBLE);

                fan.setVisibility(VISIBLE);
                off.setVisibility(INVISIBLE);
                bar1.setVisibility(VISIBLE);
                bar2.setVisibility(VISIBLE);
                bar3.setVisibility(VISIBLE);
                bar4.setVisibility(VISIBLE);
                bar5.setVisibility(VISIBLE);
                bar6.setVisibility(INVISIBLE);
                ac.setVisibility(VISIBLE);
                symb.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);

            }
             if(msg.obj.equals("8")){
                louder.setVisibility(VISIBLE);
             }
            if(msg.obj.equals("9")){
                louder.setVisibility(INVISIBLE);
            }
            if (msg.obj.equals("r")) {
                auto.setVisibility(VISIBLE);
                recicle.setVisibility(INVISIBLE);
                fan.setVisibility(VISIBLE);
                off.setVisibility(INVISIBLE);
                bar1.setVisibility(VISIBLE);
                bar2.setVisibility(VISIBLE);
                bar3.setVisibility(VISIBLE);
                bar4.setVisibility(INVISIBLE);
                bar5.setVisibility(INVISIBLE);
                bar6.setVisibility(INVISIBLE);

                symb.setVisibility(VISIBLE);
                symb1.setVisibility(VISIBLE);
                sybm2.setVisibility(VISIBLE);
                value1.setVisibility(VISIBLE);

            }


            if (msg.obj.equals("W")) {

                mFloatingWindow.LFDO();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mFloatingWindow.RemoveView();


                    }
                }, 5000);


            }
            if (msg.obj.equals("w")) {


                mFloatingWindow.LFDC();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mFloatingWindow.RemoveView();

                    }
                }, 5000);


            }

            if (msg.obj.equals("X")) {

                mFloatingWindow.RFDO();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mFloatingWindow.RemoveView();


                    }
                }, 5000);


            }

            if (msg.obj.equals("x")) {


                mFloatingWindow.RFDC();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mFloatingWindow.RemoveView();

                    }
                }, 5000);


            }

            if (msg.obj.equals("Z")) {

                mFloatingWindow.LBDO();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mFloatingWindow.RemoveView();


                    }
                }, 5000);


            }

            if (msg.obj.equals("z")) {


                mFloatingWindow.LBDC();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mFloatingWindow.RemoveView();

                    }
                }, 5000);


            }

            if (msg.obj.equals("B")) {

                mFloatingWindow.RBDO();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mFloatingWindow.RemoveView();


                    }
                }, 5000);


            }

            if (msg.obj.equals("b")) {


                mFloatingWindow.RBDC();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mFloatingWindow.RemoveView();

                    }
                }, 5000);


            }



            if(msg.obj.equals("P")) {
                mcontrolservice.Voulumeup();
                mcontrolservice.view1();
                resetTime();





            }

            if(msg.obj.equals("S")){
                mcontrolservice.VolumeDown();
                mcontrolservice.view1();
                resetTime();




            }
            if(msg.obj.equals("T")){
                mcontrolservice.view2();
                mcontrolservice.balanceL();
                resetTime();



            }
            if(msg.obj.equals("U")){
                mcontrolservice.view2();
                mcontrolservice.balanceR();
                resetTime();


            }
            if(msg.obj.equals("C")){
                mcontrolservice.view3();
                mcontrolservice.frontfader();
                resetTime();

            }
            if(msg.obj.equals("E")){
                mcontrolservice.view3();
                mcontrolservice.rearfader();
                resetTime();

            }
            if(msg.obj.equals("A")){
                mcontrolservice.view3();
                resetTime();}
            if(msg.obj.equals("L")){
                mcontrolservice.view2();
                resetTime();}
            if(msg.obj.equals("J")){
                mcontrolservice.view4();
                resetTime();}
            if(msg.obj.equals("G")){
                mcontrolservice.view5();
                resetTime();}


            if(msg.obj.equals("H")){
                mcontrolservice.view4();
                mcontrolservice.bassminus();
                resetTime();
            }

            if(msg.obj.equals("I")){
                mcontrolservice.view4();
                mcontrolservice.bassplus();
                resetTime();
            }
            if(msg.obj.equals("D")){
                mcontrolservice.view5();
                mcontrolservice.trebleminus();
                resetTime();
            }
            if(msg.obj.equals("F")){
                mcontrolservice.view5();
                mcontrolservice.trebleplus();
                resetTime();
            }




        }
    }


    void selectWidget() {
        int appWidgetId = this.mAppWidgetHost.allocateAppWidgetId();
        Intent pickIntent = new Intent(AppWidgetManager.ACTION_APPWIDGET_PICK);
        pickIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        addEmptyData(pickIntent);
        startActivityForResult(pickIntent, R.id.REQUEST_PICK_APPWIDGET);
    }

    /**
     * This avoids a bug in the com.android.settings.AppWidgetPickActivity,
     * which is used to select widgets. This just adds empty extras to the
     * intent, avoiding the bug.
     * <p/>
     * See more: http://code.google.com/p/android/issues/detail?id=4272
     */
    void addEmptyData(Intent pickIntent) {
        ArrayList<AppWidgetProviderInfo> customInfo = new ArrayList<AppWidgetProviderInfo>();
        pickIntent.putParcelableArrayListExtra(AppWidgetManager.EXTRA_CUSTOM_INFO, customInfo);
        ArrayList<Bundle> customExtras = new ArrayList<>();
        pickIntent.putParcelableArrayListExtra(AppWidgetManager.EXTRA_CUSTOM_EXTRAS, customExtras);
    }

    /**
     * If the user has selected an widget, the result will be in the 'data' when
     * this function is called.
     */
    @Override
   final public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == R.id.REQUEST_PICK_APPWIDGET) {
                configureWidget(data);
            } else if (requestCode == R.id.REQUEST_CREATE_APPWIDGET) {
                createWidget(data);
            }
        } else if (resultCode == RESULT_CANCELED && data != null) {
            int appWidgetId = data.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, -1);
            if (appWidgetId != -1) {
                mAppWidgetHost.deleteAppWidgetId(appWidgetId);
            }
        }

    }


    /**
     * Checks if the widget needs any configuration. If it needs, launches the
     * configuration activity.
     */
    public void configureWidget(Intent data) {
        Bundle extras = data.getExtras();
        int appWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, -1);
        AppWidgetProviderInfo appWidgetInfo = mAppWidgetManager.getAppWidgetInfo(appWidgetId);
        if (appWidgetInfo.configure != null) {
            Intent intent = new Intent(AppWidgetManager.ACTION_APPWIDGET_CONFIGURE);
            intent.setComponent(appWidgetInfo.configure);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
            startActivityForResult(intent, R.id.REQUEST_CREATE_APPWIDGET);
        } else {
            createWidget(data);


        }

    }

    /**
     * Creates the widget and adds to our view layout.
     */
    public void createWidget(Intent data) {
        Bundle extras = data.getExtras();
        int appWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, -1);
        AppWidgetProviderInfo appWidgetInfo = mAppWidgetManager.getAppWidgetInfo(appWidgetId);

        AppWidgetHostView hostView = mAppWidgetHost.createView(this, appWidgetId, appWidgetInfo);
        hostView.setAppWidget(appWidgetId, appWidgetInfo);
        mainlayout.addView(hostView);

        Log.i(TAG, "The widget size is: " + appWidgetInfo.minWidth + "*" + appWidgetInfo.minHeight);


    }

    /**
     * Registers the AppWidgetHost to listen for updates to any widgets this app
     * has.
     */


    public void removeWidget(AppWidgetHostView hostView) {
        mAppWidgetHost.deleteAppWidgetId(hostView.getAppWidgetId());
        mainlayout.removeView(hostView);
    }

    /**
     * Handles the menu.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i(TAG, "Menu selected: " + item.getTitle() + " / " + item.getItemId() + " / " + R.id.addWidget);
        switch (item.getItemId()) {
            case R.id.addWidget:
                selectWidget();
                return true;
            case R.id.removeWidget:
                removeWidgetMenuSelected();
                return false;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Handle the 'Remove Widget' menu.
     */
    public void removeWidgetMenuSelected() {
        int childCount = mainlayout.getChildCount();
        if (childCount > 1) {
            View view = mainlayout.getChildAt(childCount - 1);
            if (view instanceof AppWidgetHostView) {
                removeWidget((AppWidgetHostView) view);
                Toast.makeText(this, R.string.widget_removed_popup, Toast.LENGTH_SHORT).show();
                return;
            }
        }
        Toast.makeText(this, R.string.no_widgets_popup, Toast.LENGTH_SHORT).show();
    }


    /**
     * Creates the menu with options to add and remove widgets.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }
    ServiceConnection mConnection1 = new ServiceConnection() {

        public void onServiceDisconnected(ComponentName name) {
         //   Toast.makeText(getApplicationContext(), "SoundService is disconnected", Toast.LENGTH_LONG).show();
            mBounded1 = false;
            mcontrolservice = null;
        }

        public void onServiceConnected(ComponentName name, IBinder service) {

            mBounded1 = true;
            SoundControlService.LocalBinder mLocalBinder = (SoundControlService.LocalBinder) service;
            mcontrolservice = mLocalBinder.getServerInstance();
           // Toast.makeText(getApplicationContext(), "SoundService is connected", Toast.LENGTH_SHORT).show();
        }
    };


            ServiceConnection mConnection = new ServiceConnection() {

                public void onServiceDisconnected(ComponentName name) {
                  //  Toast.makeText(getApplicationContext(), "DoorNotifierService is disconnected", Toast.LENGTH_LONG).show();
                    mBounded = false;
                    mFloatingWindow = null;
                }

                public void onServiceConnected(ComponentName name, IBinder service) {
                    mBounded = true;
                    FloatingWindow.LocalBinder mLocalBinder = (FloatingWindow.LocalBinder) service;
                    mFloatingWindow = mLocalBinder.getServerInstance();
                //    Toast.makeText(getApplicationContext(), "DoorNotifierService is connected", Toast.LENGTH_SHORT).show();
                }
            };

            @Override
            protected void onStop() {
                super.onStop();
                if (mBounded) {
                    unbindService(mConnection);
                    mBounded = false;}

}

            @Override
            protected void onStart() {
                super.onStart();
              mAppWidgetHost.startListening();
                Intent mIntent = new Intent(Home.this, FloatingWindow.class);
                bindService(mIntent, mConnection, BIND_AUTO_CREATE);
                Intent mIntent1 = new Intent(Home.this, SoundControlService.class);
                bindService(mIntent1, mConnection1, BIND_AUTO_CREATE);
           }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.



    }



}






