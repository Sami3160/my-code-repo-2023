package problems;

class Data {
    private boolean ready = false;

    public synchronized void produce() {
        ready = true;
        System.out.println("Data ready");

        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (!ready) {
            wait();
        }

        System.out.println("Consuming data");
    }
}