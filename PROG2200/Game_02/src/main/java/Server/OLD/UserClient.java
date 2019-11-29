//package Server.OLD;
//
//import org.lwjglb.Database.ObjDbConverter;
//import org.lwjglb.engine.items.GameItem;
//
//import javax.swing.*;
//import java.net.InetAddress;
//import java.net.Socket;
//import java.util.ArrayList;
//
//public class UserClient extends JPanel{
//
//    private ArrayList<GameItem> l = new ArrayList<>();
//    private String server;
//
//    private InetAddress address;
//    private Socket sock;
//    private static final int TIMEOUT = 0; // 0 = no time out
//
//    String myIP;
//
//    NetWriter sender;
//
//    // A timer to refresh the screen
////    static Timer timer;
////todo: Okay, working theory is this needs to become a method in Main/GameItem/Idfk
//    public UserClient(String server) {
//        this.server = server;
//
//        try {
//            address = (InetAddress.getByName(this.server));
//            sock = new Socket(address, ObjDbConverter.serverport);
//            sock.setSoTimeout(TIMEOUT);
//            myIP = sock.getLocalAddress().toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // SendHandler sender = new SendHandler(sock);
//        // sender.start();
//
//        sender = new NetWriter(sock);
//        sender.start();
//
//        // Set up Timer callbacks
////        timer = new Timer(5, this); // Set time, and this object gets event
////        timer.setInitialDelay(20); //
////        timer.setCoalesce(true); // Don't stack up events
////        timer.start(); // Start the timer object
//
////        // Set up events to handle new animals from Network
////        NetReader getter = new NetReader(sock);
////        (new Thread(getter)).start();
////
////        // We get incoming network messages
////        getter.addObserver(this);
////
////        // we trap our own keystrokes
////        this.addKeyListener(this);
//
//    }
//}
