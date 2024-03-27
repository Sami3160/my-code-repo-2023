import java.io.*;

public class VowelCheck {
    public static void main(String[] args) throws IOException {
        FileReader rd = new FileReader(new File("abc.txt"));
        int wc = 0, vowc = 0, ac = 0; // c means count
        int ch;
        System.out.println("Displaying content...\n+---------------+");
        while ((ch = rd.read()) != -1) {
            System.out.print((char) ch);
            if ((char) ch == 'a' || (char) ch == 'e' || (char) ch == 'i' || (char) ch == 'o' || (char) ch == 'u')
                vowc++;
            if ((char) ch == ' ')
                wc++;
            if ((char) ch == 'a')
                ac++;
        }

        System.out.println("\n+---------------+\nNumber of Vowels : " + vowc);
        System.out.println("Total word count : " + wc);
        System.out.println("Count of appearances of a : " + ac);

    }
}
