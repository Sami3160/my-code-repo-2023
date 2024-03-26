import java.io.*;

public class CharStream {
    public static void main(String[] args) throws IOException {
        File f1 = new File("./" + args[0]);
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        if (!f1.exists()) {
            f1.createNewFile();
        }
        FileReader fReader = new FileReader(f1);
        FileWriter fWriter = new FileWriter(f1);

        while (true) {
            int ch;
            System.out.println("Displying file contents...");
            while ((ch = fReader.read()) != -1) {
                System.out.print((char) ch);
            }

            System.out.println("\nDo you want to add data the end of tha file??? (yes/no)");
            String res = inp.readLine();
            if (res.equals("yes")) {
                System.out.println("Name: ");
                String name = inp.readLine();
                System.out.println("Age: ");
                String age = inp.readLine();
                System.out.println("Birth date: ");
                String bdate = inp.readLine();
                fWriter.write("\n+---------------+");
                fWriter.write("\nName: " + name);
                fWriter.write("\nAge: " + age);
                fWriter.write("\nBirth date: " + bdate);
                fWriter.write("\n+---------------+\n");
                fWriter.flush();
            } else if (res.equals("exit")) {
                fWriter.close();
                fReader.close();
                inp.close();
                // System.exit(0);
                return;
            } else {
                System.out.println("Displaying currents contents");
                while ((ch = fReader.read()) != -1) {
                    System.out.print((char) ch);
                }
                System.out.println();
            }
        }

    }
}
