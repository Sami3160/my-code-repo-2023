package twoPointer;

public class maxNum {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int j = 0, k = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[k] != 1) {
                j = k;
                k++;
            } else {
                k++;
            }
            if(k-j>max)max=k-j;
        }
        return k - j;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));
    }
}
