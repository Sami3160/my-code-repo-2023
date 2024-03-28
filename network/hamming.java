import java.util.Scanner;
import java.lang.Math;

/**
 * hamming
 */
public class hamming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the data");
        int size = sc.nextInt();
        int data[] = new int[size];
        for (int i = 0; i < data.length; i++) {
            System.out.println("data[" + i + "]: ");
            data[i] = sc.nextInt();
        }
        System.out.println("///////////////////////////");
        int[] data2 = getNewData(data);
        for (int i = 0; i < data2.length; i++) {
            System.out.println(data2[i]);
        }
    }

    public static int[] getNewData(int[] data) {
        int r = 0, m = data.length;
        while ((int) Math.pow(2, r) < (m + r + 1)) {
            r++;
        }
        int[] newData = new int[(r + m)];

        //adding spaces for pi bits
        int j = 0, k = 0;
        for (int i = 0; i < newData.length; i++) {
            if (i+1 != (int) Math.pow(2, k) ) {
                newData[i] = data[j];
                j++;
            } else {
                k++;
            }
        }

        j = 0;
        k = 0;
        for (int i = 0; i < newData.length; i++) {
            if (i+1 == (int) Math.pow(2, k)) {
                // setting even pi bits
                int pi = 0, l ;
                for (int z = i; z < newData.length; z += (int) Math.pow(2, k) + 1) {
                    l=i;
                    System.out.println((z+1)+"\t"+i);
                    while (l < (int) Math.pow(2, k)) {
                        pi = pi ^ newData[l];
                        l++;
                    }
                }
                k++;
                newData[i]=pi;
            }
        }
        System.out.println("huihuihui");
        return newData;
    }
    public static boolean verifyHammingCode(int[] data) {
        int r = 0, m = data.length;
        while ((int) Math.pow(2, r) < (m + r + 1)) {
            r++;
        }

        int[] newData = new int[(r + m)];

        // Adding spaces for pi bits
        int j = 0, k = 0;
        for (int i = 0; i < newData.length; i++) {
            if (i + 1 != (int) Math.pow(2, k)) {
                newData[i] = data[j];
                j++;
            } else {
                k++;
            }
        }

        // Verifying the hamming code
        j = 0;
        k = 0;
        for (int i = 0; i < newData.length; i++) {
            if (i + 1 == (int) Math.pow(2, k)) {
                int pi = 0, l;
                for (int z = i; z < newData.length; z += (int) Math.pow(2, k) + 1) {
                    l = i;
                    while (l < (int) Math.pow(2, k)) {
                        pi = pi ^ newData[l];
                        l++;
                    }
                }
                k++;
                if (pi != newData[i]) {
                    return false;
                }
            }
        }

        return true;
    }
}