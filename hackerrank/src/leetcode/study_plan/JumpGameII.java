package leetcode.study_plan;

public class JumpGameII {

    public static void main(String[] args) {

        int nums[] = {2,3,1,1,4};
//        int nums[] = {2,1,3,1,4};
//        int nums[] = {1,2,0,4,1,2,4,1,4};
//        int nums[] = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
//        int nums[] = {1,17,3,2};
        System.out.println(jump2(nums));
    }

    public static int jump(int[] nums) {
        if(nums.length == 1) return 0;
        if(nums.length > 0 && nums[0] >= nums.length -1) return 1;

        int maxJump = nums[0] -1 ;
        int count = 0;
        int markMaximumIndex = 0;
        int markMaximumValue = nums[0];

        int i = 1;
        while ( i < nums.length) {

            if(markMaximumValue + markMaximumIndex < nums[i] + i) {
                markMaximumValue = nums[i];
                markMaximumIndex = i;

            }
            if(maxJump == 0 || i == nums.length -1) {
                count ++;
                if(markMaximumIndex + markMaximumValue >= nums.length -1) return count + 1;
                maxJump = markMaximumValue -1;
                 i = markMaximumIndex + 1;
                continue;
            }

            maxJump--;
            i++;
        }
        return count;
    }

    public static int jump2(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            // Track the farthest point that can be reached
            farthest = Math.max(farthest, i + nums[i]);

            // If we've reached the end of the current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // Early stop if already can reach or exceed the end
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}
