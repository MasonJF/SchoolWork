package com.example.networkapp;

import androidx.appcompat.app.AppCompatActivity;
import com.example.networkapp.Client.*;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static Client localclient = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        localclient = new Client();
        localclient.start();

        // Add Bouncing Ball ... hard code Server IP (ok for emulator, bad for pys. device)
        // http://www3.ntu.edu.sg/home/ehchua/programming/android/Android_2D.html
        View bouncingBallView = new BouncingBallView(this, "172.16.10.10");
        setContentView(bouncingBallView);
    }


    public void sendMessage(View view) {

        EditText editText = (EditText) findViewById(R.id.server_ip);
        String Server_IP = editText.getText().toString();

        View bouncingBallView = new BouncingBallView(this, Server_IP);
        setContentView(bouncingBallView);

        Log.v("BouncingBallLog", "Start with Server IP = " + Server_IP);

    }

}
