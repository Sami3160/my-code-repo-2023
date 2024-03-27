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
                // setting even pi bits
                // int pi=0,l=0;
                // for(int z=(int)Math.pow(2, k); z<newData.length; z+=(int)Math.pow(2, k)+1){
                // l=z;
                // while (l<=(int)Math.pow(2, k)) {
                // pi=pi ^ newData[l];
                // l++;
                // }
                // }
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

        // even parity
        // int[] pi = new int[r];
        // int temp = 0;
        // int res = 0;
        // for (int i = 0; i < r; i++) {
        // res = 0;
        // temp = i;
        // j = i + 1;
        // while (temp < newData.length) {
        // int k = 0;
        // while (k < j) {
        // if (newData[temp] == -1)newData[temp] = 0;
        // res = res ^ newData[temp];
        // System.out.println(newData[temp]+"\t"+j);
        // temp++;
        // k++;
        // }
        // k = 0;
        // while (k < j) {
        // temp++;
        // k++;
        // }
        // }
        // // System.out.println(res);
        // newData[(int) Math.pow(2, i) - 1] = res;
        // }

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