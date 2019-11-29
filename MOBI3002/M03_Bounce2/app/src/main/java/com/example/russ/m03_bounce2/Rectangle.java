package com.example.russ.m03_bounce2;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import java.util.Random;

public class Rectangle extends Shape{

    // Constructor
    public Rectangle(int color) {
       super(color);
    }

    // Constructor
    public Rectangle(int color, float x, float y, float speedX, float speedY) {
        super(color, x, y, speedX, speedY);
    }


    public void draw(Canvas canvas) {
        bounds.set(x - radius*2, y - radius, x + radius*2, y + radius);
        canvas.drawRect(bounds, paint);
    }

}
