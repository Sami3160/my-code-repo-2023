import java.io.*;
public class DataStream {
    public static void main(String[] args) throws IOException{
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        DataInputStream datain=new DataInputStream(new FileInputStream("./abc.txt"));
        DataOutputStream dataout=new DataOutputStream(new FileOutputStream("./abc.txt"));

        System.out.println("Enter student name: ");
        String name=inp.readLine();
        dataout.writeUTF("\nName: "+name);


        System.out.println("Enter student age: ");
        String age=inp.readLine();
        dataout.writeUTF("\nAge: "+age);


        System.out.println("Enter primary address: ");
        String Address=inp.readLine();
        dataout.writeUTF("\nAddress: "+Address);


        System.out.println("Enter the contact number: ");
        String ContactNo=inp.readLine();
        dataout.writeUTF("\nContact No. : "+ContactNo);


        System.out.println("\nDisplaying data\n+---------------+");
        System.out.println(datain.readUTF());
        System.out.println(datain.readUTF());
        System.out.println(datain.readUTF());
        System.out.println(datain.readUTF());

        datain.close();
        dataout.close();
    }
}
