package leetcode.dynamic_programming;

public class JumpGameII {

    /*
    * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
0 <= j <= nums[i] and i + j < n. Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
*
* Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
    * */


    public static void main(String[] args) {
        int a[] = {1,2,1,1,1};
        System.out.println(jump(a));
    }

    public static int jump(int[] nums) {
        if(nums[0] == 0) return 0;
        if(nums.length == 1) return 0;
        return jump(nums, 0, 1, Integer.MAX_VALUE);
    }

    public static int jump(int [] nums, int j, int count, int result2) {
        if( j + 1 + nums[j] >= nums.length) {
            return Math.min(count, result2);
        }

        for(int i = j + 1; i <= j + nums[j]; i++) {
            result2 = Math.min(result2, jump(nums, i, count + 1, result2)) ;
        }

        return result2;
    }


//    public static int jump(int[] nums, int k) {
//        int dp[] = new int[nums.length];
//        int max = Integer.MIN_VALUE;
//
//        int start = k;
//
//        for(int i = nums.length -1; i >= 0; i--) {
//            if(start >0) {
//                dp[i] = nums[i];
//                max = Math.max(dp[i], max);
//                start --;
//                continue;
//            }
//            dp[i] = nums[i] + dp[i+k];
//            max = Math.max(dp[i], max);
//        }
//        return max;
//    }


}
