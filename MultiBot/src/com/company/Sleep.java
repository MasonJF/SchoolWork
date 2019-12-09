package com.company;

import org.rspeer.ui.Log;

import static java.lang.Thread.sleep;

public class Sleep {

    public static void mySleep(int timeToSleep) {
        try {
            int tts = timeToSleep / 1000;
            while(tts != 0) {
                sleep(1000);
                Log.fine("Break Remaining: " + tts);
                tts--;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
