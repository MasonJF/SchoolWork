package com.example.russ.m03_bounce2;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import java.util.Random;

public class Square extends Shape{

    public Square(int color) {
        super(color);
    }

    // Constructor
    public Square(int color, float x, float y, float speedX, float speedY) {
      super(color, x, y, speedX, speedY);
    }

    public void draw(Canvas canvas) {
        bounds.set(x - radius, y - radius, x + radius, y + radius);
        canvas.drawRect(bounds, paint);
    }

}
