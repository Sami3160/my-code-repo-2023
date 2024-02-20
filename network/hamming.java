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
        int r2 = 0;
        while ((int) Math.pow(2, r2) < (m + r + 1)) {
            newData[(int) (Math.pow(2, r2) - 1)] = -1;
            r2++;
        }
        int j = 0;
        for (int i = 0; i < newData.length; i++) {
            if (newData[i] != -1) {
                newData[i] = data[j];
                j++;
            }
        }
        // even parity
        int[] pi = new int[r];
        int temp = 0;
        int res = 0;
        for (int i = 0; i < r; i++) {
            res = 0;
            temp = i;
            j = i + 1;
            while (temp < newData.length) {
                int k = 0;
                while (k < j) {
                    if (newData[temp] == -1)newData[temp] = 0;
                    res = res ^ newData[temp];
                    System.out.println(newData[temp]+"\t"+j);
                    temp++;
                    k++;
                }
                k = 0;
                while (k < j) {
                    temp++;
                    k++;
                }
            }
            // System.out.println(res);
            newData[(int) Math.pow(2, i) - 1] = res;
        }

        // new even parity
        // int[] pi = new int[r];
        // int res = 0;
        // for (int i=0; i<r; i++) {
        // res = 0;
        // int position = (int) Math.pow(2, i);
        // for (int l=position;l <newData.length;l+=position *2) {
        // for (int k=l;k<l+position&&k< newData.length; k++) {
        // if (newData[k] ==-1)
        // newData[k]= 0;
        // res=res ^newData[k];
        // }
        // }
        // newData[position- 1] = res;
        // }
        System.out.println("huihuihui");
        return newData;
    }
}