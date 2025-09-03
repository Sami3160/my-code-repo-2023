public class inverCount{
    public int solution(int[] arr, int i, int j){
        if(j - i <= 1) return 0;
        int mid = i + (j - i) / 2;
        int leftCount = solution(arr, i, mid);
        int rightCount = solution(arr, mid, j);
        int lvlCount = dc(arr, i, mid, j);
        return lvlCount + leftCount + rightCount;
    }
    // int count=0;
    // int count=0;
    public int dc(int[] arr, int start, int mid, int end){
        int i = start, j = mid;
        int[] temp = new int[end - start];
        int k = 0;
        int count = 0;
        while(i < mid && j < end){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
                count += (mid - i);
            }
        }
        while(i < mid){
            temp[k++] = arr[i++];
        }
        while(j < end){
            temp[k++] = arr[j++];
        }
        for(int x = 0; x < temp.length; x++){
            arr[start + x] = temp[x];
        }
        return count;
    }

    
    public static void main(String[] args) {
        int[] arr={2, 4, 1, 3, 5};
        inverCount ic=new inverCount();
        System.out.println(ic.solution(arr, 0, arr.length));    
        // System.out.println(ic.solution(arr, 0, arr.length));
    }
}        
