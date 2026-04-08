 
class A {}
class B {}

public class Main {
    static A objA = new A();
    static B objB = new B();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (objA) {
                System.out.println("Thread1 locked A");
                System.out.println(objB.toString());
                try {
                    Thread.sleep(4000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                // synchronized (objB) {
                //     System.out.println("Thread1 locked B");
                // }
            }
            System.out.println("Thread 1 Exiecution done");
        });

        Thread t2 = new Thread(() -> {
            synchronized (objB) {
                System.out.println("Thread2 locked B");
                System.out.println(objA.toString());

                // synchronized (objA) {
                //     System.out.println("Thread2 locked A");
                // }
            }
            System.out.println("Thread 2 Exiecution done");
        });

        t1.start();
        t2.start();
    }
}