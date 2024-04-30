    public class producerConsumer {
        boolean produced = false;

        public void produce() throws Exception {
            if (produced) {
                System.err.println("Producer: Already produced. Waiting for consumer to consume.");
                return;
            }
            System.out.println("Producer: Producing...");
            Thread.sleep(2000);
            produced = true;
            System.out.println("Producer: Produced.");
        }

        public void consume() throws Exception {
            if (!produced) {
                System.err.println("Consumer: Nothing to consume. Waiting for producer to produce.");
                return;
            }
            System.out.println("Consumer: Consuming...");
            Thread.sleep(2000);
            produced = false;
            System.out.println("Consumer: Consumed.");
        }

        public static void main(String[] args) throws Exception {
            producerConsumer pc = new producerConsumer();
            pc.produce();
            // pc.produce();
            pc.consume();
            pc.consume();
        }
    }