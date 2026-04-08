class MyThread extends Thread{
    public void run(){
        try {
            
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println("sup");
    }
    public static void main(String[] args) {
        MyThread t1=new MyThread();
        Thread t2=new Thread(new MyThread2());
        Thread t3=new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Thread 3");
        });
        t1.start();
        
        t2.start();
        t3.start();


        new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
            }
            System.out.println("thread 4 with run()");
        }).start();

    }
}


class MyThread2 implements Runnable{

    @Override
    public void run() {
        try {
            
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        System.out.println("from thread 2");
    }
}

