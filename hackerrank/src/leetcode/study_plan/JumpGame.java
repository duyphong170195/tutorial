package leetcode.study_plan;

public class JumpGame {

    public static void main(String[] args) {
//        int nums[] = {3,2,1,0,4};
//        int nums[] = {2,0,1,1,2,1,0,0,0};
        int nums[] = {3,4,3,1,0,7,0,3,0,2,0,3};
//        int nums[] = {2,3,1,1,4};
//        int nums[] = {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(canJump2(nums));
    }

    public static boolean canJump(int[] nums) {
        if(nums.length >0 && nums[0] == 0) return false;
        if(nums.length > 0 && nums[0] >= nums.length -1) return true;

        for(int i = 1; i< nums.length; i++) {

            int j = 0;
            boolean checkReach = false;
           while( j < i) {
               if(nums[j] + j >= i) {
                   if(nums[i] + i >= nums.length -1) return true;
                   checkReach = true;
               }
               j++;
           }
           if (checkReach == false) return false;
        }
        return false;
    }

    public static boolean canJump2(int[] nums) {
        if(nums.length == 1 && nums[0] == 0) return true;
        if(nums.length > 1 && nums[0] == 0) return false;
        if(nums.length > 0 && nums[0] >= nums.length -1) return true;

        int maxJump = nums[0] -1 ;
        for(int i = 1; i< nums.length; i++) {

            if(nums[i] == 0 && ((maxJump == 0))) return false;

            if(nums[i] > maxJump) {
                maxJump = nums[i];
                if( i + maxJump >= nums.length -1) return true;
            }
            maxJump--;
        }
        return false;
    }
}
