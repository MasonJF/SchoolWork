package Server;

import org.lwjglb.Database.ObjDbConverter;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread{

    public static final Integer serverport = 53475;
    private ServerSocket serverSocket;
    ArrayList<NetWriter> clients = new ArrayList<NetWriter>();

//    ObjectOutputStream outputStream;
//    Socket socket = serverSocket.accept();

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("We are SERVER SIR.");
            System.out.println("IP=172.16.176");
            System.out.println("Port=" + serverport);
//            outputStream = new ObjectOutputStream(serverSocket)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            mySleep(10);
            try {
                Socket socket = serverSocket.accept();
                NetWriter writer = new NetWriter(socket);
                clients.add(writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public synchronized void sendToClient(List<ObjDbConverter> obj) {
        for (NetWriter e: clients) {
            e.sendObject(obj);
        }
    }


    public void mySleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
