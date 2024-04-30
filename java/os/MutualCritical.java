public class MutualCritical {
    public static void main(String[] args) {
        MutualCritical mc = new MutualCritical();
        
        new Thread(()->{
            mc.criticalSection();
        }).start();
        new Thread(()->{
            mc.criticalSection();
        }).start();
    }   

    public synchronized void criticalSection() {
        System.out.println("In critical section");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Out of critical section");

    }

}