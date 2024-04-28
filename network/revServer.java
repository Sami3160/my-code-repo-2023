
import java.net.*;
import  java.io.*;
public class revServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6000);
            Socket s = ss.accept();
            System.out.println("Connected to client...");
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dot = new DataOutputStream(s.getOutputStream());
            String str = "";
            while (true) {
                str = din.readUTF();
                System.out.println("Original string : " + str);
                char ch[]=str.toCharArray();
                
                str="";
                char tmp;
                for (int i = 0; i < ch.length/2; i++) {
                    tmp=ch[i];
                    ch[i]=ch[ch.length-i-1];
                    ch[ch.length-i-1]=tmp;
                }
                str=new String(ch);
                System.out.println("Reversed string : " + str);
                dot.writeUTF(str);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
