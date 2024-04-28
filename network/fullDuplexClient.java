import java.io.*;
import java.net.*;
import java.util.Scanner;

public class fullDuplexClient {
    static Socket s;
    static DataOutputStream dot;
    static DataInputStream din;

    public static void main(String[] args) {
        try {
            System.out.println("Connected to server...");
            s = new Socket("localhost", 6000);
            dot = new DataOutputStream(s.getOutputStream());
            din = new DataInputStream(s.getInputStream());
            new Thread(() -> {
                Scanner sc1 = new Scanner(System.in);
                try {

                    String msg1 = "";
                    while (true) {
                        if (msg1.equals("exit"))
                            System.exit(0);
                        System.out.print("Client : ");
                        msg1 = sc1.nextLine();
                        dot.writeUTF(msg1);
                        System.out.println();
                    }
                } catch (Exception e2) {
                    System.out.println(e2);
                }
            }).start();


            new Thread(() -> {
                try {
                    String str = "";
                    while (true) {
                        try {
                            if (str.equals("exit"))
                                break;
                            str = din.readUTF();
                            System.out.println("\nServer : " + str);
                        } catch (Exception e1) {
                            System.out.println(e1);
                        }
                    }
                } catch (Exception e1) {
                    System.out.println(e1);
                }
            }).start();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
