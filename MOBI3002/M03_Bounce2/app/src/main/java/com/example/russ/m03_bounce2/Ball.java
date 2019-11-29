package com.example.russ.m03_bounce2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

import java.util.Random;


/**
 * Created by Russ on 08/04/2014.
 */
public class Ball extends Shape{


    public Ball(int color) {
        super(color);
    }
    public Ball(int color, float x, float y, float speedX, float speedY){
        super(color, x, y, speedX, speedY);
    }
    public void draw(Canvas canvas) {
        bounds.set(x - radius, y - radius, x + radius, y + radius);
        canvas.drawOval(bounds, paint);
    }

}
