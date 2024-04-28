import java.net.*;
import java.io.*;

public class sumServer {
    public static void main(String[] args) throws Exception {
        int sum,rem=0;
        ServerSocket ss = new ServerSocket(6666);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        int num = din.readInt();
        sum = 0;
        while (num!=0) {
            rem=num%10;
            sum+=rem;
            num=num/10;            
        }
        dout.writeInt(sum);
        s.close();
        ss.close();
    }
}
