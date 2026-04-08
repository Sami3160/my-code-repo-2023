package algos;

public class bubble {
    static void sort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={6,1,5,9,2,4,3,8};
        sort(arr);
        for (int each : arr) {
            System.out.println(each);
        }
    }
}
