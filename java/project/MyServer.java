import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            String str = (String) dis.readUTF();
            System.out.println("message= " + str);
            dout.writeUTF("huihuihui by server to client....");
            dout.flush();
            dout.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}