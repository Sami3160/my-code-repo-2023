import java.util.Random;

public class stopWait {
    public static void main(String[] args) {
        Random r1 = new Random();
        int[] data = new int[8];
        for (int i = 0; i < args.length; i++) {
            data[i] = Integer.parseInt(args[i]);
        }
        int Timeout = 3;
        int actualTime = r1.nextInt(6);
        int sentDataCount = 0;
        try {

            while (sentDataCount < data.length) {
                if(actualTime>Timeout){
                    Thread.sleep(Timeout*1000);
                    System.out.println("[FRAME NOT SENT] No ack for  "+data[sentDataCount]+" frame!");
                    System.out.println("\tRetrying...\n");
                }else{
                    Thread.sleep(actualTime * 1000);
                    System.out.println("[FRAME SENT] "+data[sentDataCount]+" is sent.");
                    sentDataCount++;
                    System.out.println("\tTotal "+(sentDataCount)+" frames sent.\n");
                }
                actualTime=r1.nextInt(5);r1.nextInt(5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
