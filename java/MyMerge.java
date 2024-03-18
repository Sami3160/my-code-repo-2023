/**
 * MyMerge
 */
public class MyMerge {

     public static int[] initMerge(int[] arr){
        if(arr.length==1){
            return arr;
        }
        return divide(0, arr.length-1, arr);
     }

     public static int[] divide(int low, int high, int[]arr){
        if(low==high){
            return new int[]{arr[low]};
        }
        int mid=(low+high)/2;
        int[] left=divide(low, mid, arr);
        int[] right=divide(mid+1, high, arr);
        return conqure(left, right);
     }

     public static int[] conqure(int[] arr1, int[] arr2){

        //arr1 is left and arr2 is right
        int[] newsorted=new int[arr1.length+ arr2.length];
        int l=0, r=0, i=0; //left array's first index and right arrays....
        while (l!=arr1.length || r!=arr2.length) {
            //below code add smallst remaining element in array..
            if(l==arr1.length){         //when l reach to end of arr1 index then add arr2[r] ele in new array
                newsorted[i]=arr2[r];
                r++;
            }else if (r== arr2.length) {
                newsorted[i]=arr1[l];
                l++;
            }//basic comparison logic below
            else if(arr1[l]<arr2[r]){      //initially this will execute as arr1[0]<arr2[0]
                newsorted[i]=arr1[l];
                l++;
            }else{                          //if arr1[l]>=arr2[r]
                newsorted[i]=arr2[r];       //and initially this will execute
                r++;
            }
            i++;
        }
        return newsorted;
    }
     public static void main(String[] args) {
        int[] my=new int[]{3,1,5,2,4};
        int[] newArr=initMerge(my);
        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]);   
        }
        
     }
}