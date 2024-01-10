public class LambdaExample2 {
    public static void main(String[] args) {
        //  traditional approach using an anonymous class
        Runnable traditionalRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from a traditional Runnable!huihiu!!!");
            }
        };

        //lambda expression for the same functionality
        Runnable lambdaRunnable = () -> {
            System.out.println("Ohayo! from a lambda Runnable!");
        };

        //execute the run methods
        traditionalRunnable.run();
        lambdaRunnable.run();
    }
}