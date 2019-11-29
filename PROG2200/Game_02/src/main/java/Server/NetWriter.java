package Server;

import org.lwjglb.Database.ObjDbConverter;
import org.lwjglb.engine.items.GameItem;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class NetWriter {

    private Socket sock;
    private ObjectOutputStream out;

    public NetWriter(Socket stickySock) {
        sock = stickySock;
        try {
            out = new ObjectOutputStream(sock.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendObject(List<ObjDbConverter> obj) {
        try {
            out.reset();
            out.writeObject(obj);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
