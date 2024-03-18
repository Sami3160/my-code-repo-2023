import java.io.File;
import java.io.IOException;

class FIieClass {
    public static void main(String[] args) throws IOException {
        File f1=new File("sample1.txt");
        // System.out.println(f1.getCanonicalPath());
        // System.out.println(f1.getAbsolutePath());
        // System.out.println(f1.canExecute());
        // System.out.println(f1.compareTo(f1.getAbsoluteFile()));
        System.out.println(f1.createNewFile());
        // f1.renameTo(new File("eheheh.txt"));


        File folder = new File("path/to/folder");
        folder.mkdirs();

        if (folder.exists()) {
            File[] files = folder.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Folder: " + file.getName());
                }
            }
        } else {
            System.out.println("Folder does not exist.");
        }


    }

}