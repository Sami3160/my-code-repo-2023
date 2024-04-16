package twoPointer;
import java.util.Arrays;
public class newSubArrayLength {
    public static int minSubArrayLen(int target, int[] nums) {
        Arrays.sort(nums);
        // int i=0,j=nums.length;
        int end=nums.length-1,start=nums.length-1,sum=0,tmp=0;
        while(start>0){
            tmp=end;
            for(;end>=start;end--){
                sum+=nums[end];
            }
            end=tmp;
            System.out.println(start+"  "+end);
            if(sum>=target)return nums.length-start; 
            start-=1;
            
            sum=0;
        }
        return 0;
        
    }
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(213, new int[]{12,28,83,4,25,26,25,2,25,25,25,12}));
    }
}
