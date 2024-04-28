import java.net.*;
import java.io.*;
public class simpleServer {
    public static void main(String[] args)throws Exception {
        //sever to recieve and send data as chcat application
        ServerSocket ss=new ServerSocket(6666);
        Socket s=ss.accept();
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        String str="";
        while(true){
            str=din.readUTF();
            System.out.println("Client : "+str);
            if(str.equals("bye")){
                System.out.println("Exited by client");
                break;
            }
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            str=br.readLine();
            dout.writeUTF(str);
        }

    }
}
