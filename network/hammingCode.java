public class hammingCode {
    public static void main(String[] args) {
        int[] data = { 1, 0, 1, 0, 0, 1, 0, 1 };
        int r = 0;
        while (Math.pow(2, r) < data.length + r + 1) {
            r++;
        }
        int[] code = new int[data.length + r];
        int j = 0;
        for (int i = 0; i < code.length; i++) {
            if (Math.pow(2, j) == i + 1) {
                j++;
            } else {
                code[i] = data[i - j];
            }
        }

        for (int i = 0; i < r; i++) {
            int x = (int) Math.pow(2, i);
            for (int k = x - 1; k < code.length; k += 2 * x) {
                for (int l = k; l < k + x && l < code.length; l++) {
                    code[x - 1] = code[x - 1] ^ code[l];
                }
            }
        }
        System.out.println("Daata : ");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("\nCode: ");
        for (int i = 0; i < code.length; i++) {
            System.out.print(code[i] + " ");
        }
    }
}
