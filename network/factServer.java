    import java.io.*;
    import java.net.*;
    public class factServer {
        public static void main(String[] args) {
            try {
                ServerSocket ss=new ServerSocket(6000);
                Socket s=ss.accept();
                System.out.println("Connected to server");
                DataInputStream din = new DataInputStream(s.getInputStream());
                DataOutputStream dot = new DataOutputStream(s.getOutputStream());
                int num = 0;
                while (true) {
                    num = din.readInt();
                    if(num==-1)break;
                    if(num==0 || num==1){
                        dot.writeInt(num);
                    }else{
                        int i=1,temp=1;
                        while(i<=num){
                            temp*=i;
                            i++;
                        }
                        dot.writeInt(temp);
                    }
                }
                ss.close();
                s.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
