///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package Server.OLD;
//
////import com.example.russ.m08_net_01.common.*;
////import com.example.russ.m08_net_01.common.ObjDbConverter.Animal;
//import org.lwjglb.Database.ObjDbConverter;
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author Russ
// *
// *
// */
//public class ServerHandler extends Thread {
//
//	Socket sock = null;
//	ServerSocket serverSocket = null;
//
//	private boolean more = true;
////	private final Integer serverport = ObjDbConverter.serverport;
//
//	ArrayList<NetWriter> clients = new ArrayList<NetWriter>();
//
//	public ServerHandler() {
//		super("Client Server Thing");
//		try {
////			serverSocket = new ServerSocket(serverport.intValue());
//			System.out.println("CST listening/Getting on port: " + serverSocket.getLocalPort());
//		} catch (IOException e) {
//			System.err.println("Could not create datagram socket.");
//		}
//	}
//
//	Boolean duplicate = false;
//
//	@Override
//	public void run() {
//		if (serverSocket == null) {
//			return;
//		}
//
//		while (more) {
//			System.out.println("Waiting for next client.....");
//			try {
//				sock = serverSocket.accept();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//
//			// Launch Reader Thread to handle this new client
//			NetReader reader = new NetReader(sock);
//			// reader.start();
//			(new Thread(reader)).start();
//
//			NetWriter writer = new NetWriter(sock);
//			writer.start();
//
//			clients.add(writer);
//			System.out.println("Writer Array Size: " + clients.size());
//			for (NetWriter w : clients) {
//				System.out.print(" :: " + w.getIP());
//			}
//
//			// Let's get some stuff over at the client as default
//			writer.sendThisMsgOnQueue(new ObjDbConverter(10, 10, 10, "LandVehicle"));
//
////			writer.sendThisMsgOnQueue(new ObjDbConverter(ObjDbConverter.Animal.Turtle, rnd(100), rnd(100), rnd(10),
////					rnd(10), NetColor.RED, "Russ 2"));
////
////			writer.sendThisMsgOnQueue(new ObjDbConverter(ObjDbConverter.Animal.Turtle, rnd(100), rnd(100), rnd(10),
////					rnd(10), NetColor.RED, "Russ 3"));
////
////			writer.sendThisMsgOnQueue(new ObjDbConverter(ObjDbConverter.Animal.Turtle, rnd(100), rnd(100), rnd(10),
////					rnd(10), NetColor.RED, "Russ 4"));
//
//		}
//
//		try {
//			serverSocket.close();
//		} catch (IOException ex) {
//			Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
//		}
//	}
//
//	private int rnd(int max) {
//		int r = (int) (Math.random() * max);
//		return r;
//	}
//
//
////		if (event instanceof com.example.russ.m08_net_01.common.NetworkCommand) {
////			com.example.russ.m08_net_01.common.NetworkCommand e = new com.example.russ.m08_net_01.common.NetworkCommand(
////					(NetworkCommand) event);
////
////			switch (e.getComm()) {
////			case Add_Animal:
////				break;
////			case Change_Movement:
////				break;
////			case No_Command:
////				break;
////			case Remove_Animal:
////				break;
////			case Reset:
////				// Send new animal to all clients (including sender)
////				for (NetWriter w : clients) {
////					w.sendThisMsgOnQueue(e);
////					System.out.print("send reset to " + w.getIP());
////				}
////				break;
////			default:
////				break;
////
////			}
////
////		}
//
//	}
//
