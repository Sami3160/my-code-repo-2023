//functional interface with a single method that takes two integers and returns their sum
interface MathOperation {
    int operate(int a, int b);
}

public class LambdaExample {
    public static void main(String[] args) {
        // old traditional approach using an anonymous class(this technique is so verbose) 
        MathOperation traditionalAddition = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };

        //lambda expression for the same functionality(now this is good :D)
        MathOperation lambdaAddition = (int a, int b) -> a + b;

        // execute the operate method
        System.out.println("Traditional Addition: " + traditionalAddition.operate(5, 3));
        System.out.println("Lambda Addition: " + lambdaAddition.operate(5, 3));
    }
}
