package leetcode.twopointers;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        print(nums);
        int closestSum = -4000;
        for(int i = 0; i<nums.length-2; i++) {
            int value = nums[i] + nums[i+1] + nums[i + 2];
            if(Math.abs(value - target)  < Math.abs(closestSum - target))  {
                closestSum = value;
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        int nums[] = {4,0,5,-5,3,3,0,-4,-5};
        threeSumClosest(nums, -2);
//        System.out.println(threeSumClosest(nums, -2));
    }

    private static void print(int[] nums) {
        for (int i = 0; i< nums.length; i++)
            System.out.print(nums[i] + ",");
    }

    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[nums.length - 1];

        for(int i = 0; i < nums.length - 2 ; i++) {
            int j = i +1;
            int k = nums.length -1;
            while (j<k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == target) {
                    return sum;
                }

                if(Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                if(sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return closest;
    }
}
