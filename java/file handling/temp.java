import java.io.*;

public class temp {
    public static void main(String[] args) {
        try {
            File f1= new File("./abc2.txt");
            f1.createNewFile();
            FileReader fr = new FileReader(f1);
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
