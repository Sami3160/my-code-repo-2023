public class deadlockDetection {
    public static void main(String[] args) throws Exception{
        //Boolean.TRUE means any resource 1
        //Boolean.FALSE means any resource 2
        Thread thread1 = new Thread(() -> {
            synchronized (Boolean.TRUE) {
                System.out.println("Thread 1 acquired resource 1");
                synchronized (Boolean.FALSE) {
                    System.out.println("Thread 1 acquired resource 2");
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (Boolean.FALSE) {
                System.out.println("Thread 2 acquired resource 2");
                synchronized (Boolean.TRUE) {
                    System.out.println("Thread 2 acquired resource 1");
                }
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        if(thread1.isAlive()&& thread2.isAlive()){
            System.out.println("Deadlock detected");
        }
        else{
            System.out.println("Deadlock not detected");
        }
    }
}
