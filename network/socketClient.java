import java.io.*;
import java.net.*;
import java.util.Scanner;

public class socketClient {
    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(6000);
            Socket s=ss.accept();
            System.out.println("Connected to server");
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dot = new DataOutputStream(s.getOutputStream());
            int num = 0;
            while (num == -1) {
                num = din.readInt();
                // System.out.println("SERVER: " + msg);
                // System.out.print("CLIENT : ");
                if(num==0 || num==1){
                    dot.writeInt(num);
                }
                int i=1,temp=1;
                while(i<=num){
                    temp*=i;
                    i++;
                }
                dot.writeInt(temp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
