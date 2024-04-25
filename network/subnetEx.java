public class subnetEx {
    public static void main(String[] args) {
        String[] octs = args[0].split("\\/")[0].split("\\.");
        int[] ip = new int[4];
        for (int i = 0; i < 4; i++) {
            ip[i] = Integer.parseInt(octs[i]);
        }
        int subnet = Integer.parseInt(args[0].split("\\/")[1]);
        int[] networkAddress = new int[4];
        int[] broadcastAddress = new int[4];
        for (int i = 0; i < 4; i++) {
            if (i < subnet / 8) {
                networkAddress[i] = ip[i];
            } else if (i == subnet / 8) {
                int mask = -1 << (8 - subnet % 8);
                networkAddress[i] = ip[i] & mask;
                broadcastAddress[i] = ip[i] | (~mask);
            } else {
                networkAddress[i] = 0;
                broadcastAddress[i] = 255;
            }
        }
        System.out.println("Total available addresses: "+((int)Math.pow(2, 32-subnet)));
        System.out.println("First address: " + networkAddress[0] + "." + networkAddress[1] + "." + networkAddress[2] + "." + (networkAddress[3] + 1));
        System.out.println("Last address: " + broadcastAddress[0] + "." + broadcastAddress[1] + "." + broadcastAddress[2] + "." + (broadcastAddress[3] - 1));
    }
}