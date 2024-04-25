import java.io.*;
import java.net.*;
import java.util.Scanner;
class socketServer{
    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(6000);
            Socket s=ss.accept();
            System.out.println("Client connected");
            DataInputStream din=new DataInputStream(s.getInputStream());
            DataOutputStream dot=new DataOutputStream(s.getOutputStream());
            Scanner sc=new Scanner(System.in);
            String msg="";
            while (!msg.equals("exit")) {
                System.out.print("SERVER: ");
                dot.writeUTF(sc.nextLine());
                msg=din.readUTF();
                System.out.println("CLIENT: "+msg);
            }
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
        
    }
}