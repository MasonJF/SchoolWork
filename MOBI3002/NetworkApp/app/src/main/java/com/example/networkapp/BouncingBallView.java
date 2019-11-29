package com.example.networkapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.util.Log;
import android.widget.EditText;
import org.lwjglb.Database.ObjDbConverter;
import com.example.networkapp.Client.Box_Android;
import com.example.networkapp.Client.Client;

//import com.example.russ.m08_net_02.client.Box_Android;
//import com.example.russ.m08_net_02.client.MovingDot_Android;
//import com.example.russ.m08_net_02.common.P6_Main_Start;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.concurrent.Executors;

/**
 * Created by Russ on 08/04/2014.
 */
public class BouncingBallView extends View {

    private ArrayList<ObjDbConverter> balls = new ArrayList<ObjDbConverter>(); // list of Balls
    public static Box_Android box = null;

    // Status message to show Ball's (x,y) position and speed.
    private StringBuilder statusMsg = new StringBuilder();
    private Formatter formatter = new Formatter(statusMsg);
    private Paint paint;

    // For touch inputs - previous touch (x, y)
    private float previousX;
    private float previousY;

    // Constructor
    public BouncingBallView(Context context, String Server_IP) {
        super(context);

        final String server_ip = Server_IP;

        // Wait until server IP is entered before starting ball bouncing view

        // Set up network on another thread
//        Executors.newSingleThreadExecutor().execute(new Runnable() {
//            @Override
//            public void run() {
//                // set up network
//                //String Server_IP = "172.16.10.10";
//                P6_Main_Start.main(server_ip);   // old network start up code
//
//                // get the box
//                //box = P6_Main_Start.localClient.getBox();  // Client needs bounds, all balls created on network
//                //Log.w("BouncingBallLog", "Create new box");
//            }
//        });

        // To enable keypad
//        this.setFocusable(true);
//        this.requestFocus();
//        // To enable touch mode
//        this.setFocusableInTouchMode(true);
    }


    // Called back to draw the view. Also called after invalidate().
    @Override
    protected void onDraw(Canvas canvas) {

        if (MainActivity.localclient != null) {
            MainActivity.localclient.onDrawAll(canvas);
        }

//        // Force a re-draw
        this.invalidate();
    }

    // Called back when the view is first created or its size changes.
    @Override
    public void onSizeChanged(int w, int h, int oldW, int oldH) {

        // make box and set it
        box = new Box_Android(Color.YELLOW);  // ARGB
        Log.w("BouncingBallLog", "onSizeChanged 1");

       // ensure we push box size to client
//        if (P6_Main_Start.localClient != null) {
//            //P6_Main_Start.localClient.setBox(box);
//            Log.w("BouncingBallLog", "onSizeChanged 2");
//        }

        // Set the movement bounds for the ball
        if (box != null) {
            box.set(0, 0, w, h);
            Log.w("BouncingBallLog", "onSizeChanged w=" + w + " h=" + h);
        } else {
            Log.w("BouncingBallLog", "ERROR onSizeChanged box=null");
        }
    }


    // Touch-input handler
//
}
