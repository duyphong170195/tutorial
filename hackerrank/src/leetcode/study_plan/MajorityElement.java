package leetcode.study_plan;

import java.util.Arrays;

public class MajorityElement {

    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,2,3,5,5,5,5,5,3,3,4,4,4,5,5,5,6,6,6,7,7,7,4,7,7};
        System.out.println(majorityElement2(nums));
    }

    public static int majorityElement(int[] nums) {
        if(nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int pickedNumber1 = nums[0];
        int count1 = 1;
        int countMax = 1;
        int max = pickedNumber1;
        for(int i = 1; i< nums.length; i++) {
            if(nums[i] == pickedNumber1) {
                count1++;
            } else {
                if(count1 > countMax) {
                    max = pickedNumber1;
                    countMax = count1;
                }
                pickedNumber1 = nums[i];
                count1 = 1;
            }
        }

        if(count1 > countMax) {
            max = pickedNumber1;
        }
        return max;
    }

    public static int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
