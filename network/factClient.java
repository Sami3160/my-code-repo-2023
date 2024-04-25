import java.net.*;
import java.util.Scanner;
import java.io.*;
public class factClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 6000);
            DataOutputStream dot = new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());
            int msg = 0;
            Scanner sc = new Scanner(System.in);

            while (true) {
                if(msg==-1)break;
                System.out.print("Enter number : ");
                msg=sc.nextInt();
                dot.writeInt(msg);
                System.out.println("Factorial is "+din.readInt());
                // System.out.print("Enter number : ");

            }
            s.close();
        } catch (Exception e) {
            // TODO: handle exception
            
            System.out.println(e);
        }
    }
}
