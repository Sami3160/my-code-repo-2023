import java.io.*;
import java.net.*;

public class sumClient {
    public static void main(String[] args) throws Exception {
        Socket s=new Socket("localhost",6666);
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        int num=Integer.parseInt(args[0]);
        dout.writeInt(num);
        int sum=din.readInt();
        System.out.println("Sum is: "+sum);
        s.close();
    }
}
