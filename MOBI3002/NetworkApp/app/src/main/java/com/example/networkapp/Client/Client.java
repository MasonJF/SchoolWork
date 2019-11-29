package com.example.networkapp.Client;

//import com.example.networkapp.Network.*;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.StrictMode;

import com.example.networkapp.BouncingBallView;
//import com.example.networkapp.Database.ObjDbConverter;
import org.lwjglb.Database.ObjDbConverter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;



public class Client extends Thread {


    private String address = "172.16.176.140";
    private int port = 53475;
    private Socket socket;
    private ObjectInputStream inputStream;
    public Client localclient = null;

    public void setObject(List<ObjDbConverter> object) {
        this.object = object;
    }

    public List<ObjDbConverter> getObject() {
        return object;
    }

    private List<ObjDbConverter> object;

    public Client() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        try {
            socket = new Socket(address, port);
            System.out.println("We are the Client SIR.");
            inputStream = new ObjectInputStream(socket.getInputStream());
            object = (List<ObjDbConverter>)inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        while(true){
            try {
                object = (List<ObjDbConverter>)inputStream.readObject();
                System.out.println(object);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();

            }
        }
    }

    public synchronized void onDrawAll(Canvas canvas) {
        // Draw the components
        if (BouncingBallView.box != null) {
            Paint painter = new Paint();

            BouncingBallView.box.draw(canvas);
            for (ObjDbConverter b : getObject()) {
                float x = b.getX();
                float y = b.getZ();
                float z = b.getY();
                if (x < 0){
                    x = -x;
                }
                if(y < 0){
                    y = -y;
                }
                if (z < 0) {
                    z = -z;
                }
                if(b.getVeh_type().equals("AirVehicle")) {
                    painter.setColor(Color.GREEN);
                    canvas.drawCircle(x * 100, y*100, z*10, painter);  //draw each ball in the list
                }
                if(b.getVeh_type().equals("LandVehicle")) {
                    painter.setColor(Color.RED);
                    canvas.drawCircle(x * 100, y*100, z*10, painter);
                }
            }
        }
    }


}
