import java.io.*;
import java.net.*;
import java.util.Scanner;

public class fullDuplexServer {
    static ServerSocket ss;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dot;

    public static void main(String[] args) {
        try {
            ss = new ServerSocket(6000);
            s = ss.accept();
            System.out.println("Connected to client...");
            din = new DataInputStream(s.getInputStream());
            dot = new DataOutputStream(s.getOutputStream());

            new Thread(() -> {
                String str = "";
                while (true) {
                    try {

                        str = din.readUTF();
                        System.out.println("\nClient : " + str);
                    } catch (Exception e1) {
                        System.out.println(e1);
                    }
                }
            }).start();
            new Thread(() -> {
                Scanner sc = new Scanner(System.in);
                try {

                    String msg = "";
                    while (true) {
                        if (msg.equals("exit"))
                            System.exit(0);                        
                        System.out.print("Server : ");
                        msg = sc.nextLine();
                        dot.writeUTF(msg);
                        System.out.println();
                    }
                } catch (Exception e2) {
                    System.out.println(e2);
                }
            }).start();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
