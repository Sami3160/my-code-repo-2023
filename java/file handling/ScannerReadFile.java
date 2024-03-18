import java.io.*;
import java.util.Scanner;

public class ScannerReadFile {
    public static void main(String[] args)throws IOException{
        File obj=new File("smaple2.txt");
        if(!obj.exists()){
            obj.createNewFile();
        }

        Scanner sc=new Scanner(obj);
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }

    }
}
