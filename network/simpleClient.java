import java.net.*;
import java.io.*;
public class simpleClient {
    public static void main(String[] args)throws Exception {
            Socket s=new Socket("localhost",6666);
            DataInputStream din=new DataInputStream(s.getInputStream());
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String str="";
            while(true){
                str=br.readLine();
                dout.writeUTF(str);
                if(str.equals("bye")){
                    break;
                }
                str=din.readUTF();
                System.out.println("Server : "+str);
            }
            s.close();
    }
}
