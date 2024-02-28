import java.io.*;
import java.net.*;

public class MyClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 5000);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            while (true) {
                String newmsg=dis.readUTF();
                if (newmsg.equals("exit")) {
                    break;
                }
                if (newmsg.equals("nowu")) {
                    java.util.Scanner sc = new java.util.Scanner(System.in);
                    System.out.println("Enter your message: ");
                    String msg=sc.nextLine();
                    dout.writeUTF(msg);
                }else{
                    System.out.println(newmsg); 
                }
            }
            dout.flush();
            dout.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}