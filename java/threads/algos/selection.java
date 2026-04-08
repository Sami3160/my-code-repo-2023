package algos;

public class selection {
   static public void sort(int[] arr){
        int minIndex;
        int minNumber;
        int n=arr.length;
        for(int i=0;i<n;i++){
            minIndex=i;
            minNumber=arr[i];
            for (int j = i; j < n; j++) {
                if(minNumber>arr[j]){
                    minNumber=arr[j];
                    minIndex=j;
                }
            }
            // int temp=;
            arr[minIndex]=arr[i];
            arr[i]=minNumber;
        }
    }
    public static void main(String[] args) {
        int[] arr={7,4,3,1,2,5,6};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
