package org.lwjglb.Client;

import Server.Server;
import org.lwjglb.Database.ObjDbConverter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Client extends Thread {
    private String address = "172.16.176.140";
    private int port = Server.serverport;
    private Socket socket;
    private ObjectInputStream inputStream;

    public void setObject(List<ObjDbConverter> object) {
        this.object = object;
    }

    public List<ObjDbConverter> getObject() {
        return object;
    }

    private List<ObjDbConverter> object;

    public Client() {

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


}
