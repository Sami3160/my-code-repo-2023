public class netclass {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Invalid number of arguments. Please provide 4 octets of the IP address.");
            return;
        }

        int oct1 = Integer.parseInt(args[0]);
        int oct2 = Integer.parseInt(args[1]);
        int oct3 = Integer.parseInt(args[2]);
        int oct4 = Integer.parseInt(args[3]);
        if (oct1 >= 0 && oct1 <= 127) {
            System.out.println("Class is A");
            System.out.println("Network id: " + oct1);
            System.out.println("Host id: " + oct2 + "." + oct3 + "." + oct4);
        } else if (oct1 >= 128 && oct1 <= 191) {
            System.out.println("Class is B");
            System.out.println("Network id: " + oct1 + "." + oct2);
            System.out.println("Host id: " + oct3 + "." + oct4);
        } else if (oct1 >= 192 && oct1 <= 223) {
            System.out.println("Class is C");
            System.out.println("Network id: " + oct1 + "." + oct2 + "." + oct3);
            System.out.println("Host id: " + oct4);
        } else if (oct1 >= 224 && oct1 <= 239) {
            System.out.println("Class is D");
            System.out.println("Multicast Address");
        } else if (oct1 >= 240 && oct1 <= 255) {
            System.out.println("Class is E");
            System.out.println("Reserved");
        }

    }
}
