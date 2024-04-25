import java.net.*;
import java.io.*;
import java.util.Scanner;

public class revClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 6000);
            System.out.println("Connected to server...");
            DataOutputStream dot = new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());
            String msg = "";
            Scanner sc = new Scanner(System.in);

            while (true) {
                if (msg.equals("exit"))
                    break;
                System.out.print("Enter string : ");
                msg = sc.nextLine();
                dot.writeUTF(msg);
                System.out.println("Reverse is " + din.readUTF());
                // System.out.print("Enter number : ");

            }
            s.close();
        } catch (Exception e) {
            // TODO: handle exception

            System.out.println(e);
        }
    }
}
