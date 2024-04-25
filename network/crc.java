public class crc {
    public static void main(String[] args) {
        int[] data = { 1, 0, 0, 1, 0, 0 };
        int[] divisor = { 1, 1, 0, 1 };

        int[] dividend = new int[data.length + divisor.length - 1];
        for (int i = 0; i < data.length; i++) {
            dividend[i] = data[i];
        }
        for (int i = 0; i < data.length; i++) {
            if (dividend[i] == 1) {
                for (int j = 0; j < divisor.length; j++) {
                    dividend[i + j] = dividend[i + j] ^ divisor[j]; // Use XOR operation
                }
            }
        }
        for (int i = 0; i < data.length; i++) {
            dividend[i]=data[i];
        }
        System.out.println("\nOriginal data");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
        }
        System.out.println("\nDivisor data");
        for (int i = 0; i < divisor.length; i++) {
            System.out.print(divisor[i]);
        }
        System.out.println("\nNew data");
        for (int i = 0; i < dividend.length; i++) {
            System.out.print(dividend[i]);
        }
    }
}
