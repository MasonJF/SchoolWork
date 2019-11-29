package com.example.russ.m07_v01;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import java.util.Random;


/**
 * Created by Russ on 08/04/2014.
 */
public class Ball {

    double radius = 50;      // Ball's radius
    double x;                // Ball's center (x,y)
    double y;
    private RectF bounds;   // Needed for Canvas.drawOval
    private Paint paint;    // The paint style, color used for drawing

    // Add Acceleration
    private double ax, ay, az = 0; // Acceleration from different axis

    public void tempPosition(double y, double x) {
        this.y = (BouncingBallView.getBox().yMax / 2.0) - y;
        this.x = x / 2;
    }

    Random r = new Random();  // seed random number generator

    // Constructor
    public Ball(int color) {
        bounds = new RectF();
        paint = new Paint();
        paint.setColor(color);

        // random position and speed
        x = BouncingBallView.getBox().xMax / 2;
        y= BouncingBallView.getBox().yMax / 2.0;
    }

    // Constructor
    public Ball(int color, float x, float y, float speedX, float speedY) {
        bounds = new RectF();
        paint = new Paint();
        paint.setColor(color);

        // use parameter position and speed
        this.x = x;
        this.y = x;
//        this.speedX = speedX;
//        this.speedY = speedY;
    }

    public void moveWithCollisionDetection(Box box) {
    }

    public void draw(Canvas canvas) {
        // convert to float for bounds
        bounds.set((float) (x - radius),
                (float) (y - radius),
                (float) (x + radius),
                (float) (y + radius));
        canvas.drawOval(bounds, paint);
    }

}
