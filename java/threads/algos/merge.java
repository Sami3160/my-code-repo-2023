
public class merge {
    static public void sort(int[] arr, int i, int j){
        if(j-i<=1)return;
        int mid = i + (j - i) / 2;
        sort(arr, i, mid);
        sort(arr, mid, j);
        int trr[]=new int[j-i];
        int start=i;
        int end=mid;
        int k=0;
        while(start<mid && end<j){
            if(arr[start]<=arr[end]){
                trr[k++]=arr[start++];
            }else{
                trr[k++]=arr[end++];
            }
        }

        while(start<mid)trr[k++]=arr[start++];
        
        while(end<j)trr[k++]=arr[end++];
        
        for(int l=0;l<trr.length;l++){
            arr[i+l]=trr[l];
        }

    }

  

    public static void main(String[] args) {
        int[] arr={3,4,7,1,2,6,5};
        sort(arr, 0, arr.length);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}

