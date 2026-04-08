package algos;

public class insertions {
    static public void insertionSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int point=i;
            for(int j=i-1;j>=0;j--){
                if(arr[j]>arr[point]){
                    int temp=arr[j];
                    arr[j]=arr[point];
                    arr[point]=temp;
                    point=j;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={3,4,7,1,2,6,5};
        insertionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
