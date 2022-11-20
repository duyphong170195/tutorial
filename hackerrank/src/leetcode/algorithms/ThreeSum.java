package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> count = new ArrayList<>();
        Set<String> distinctThreeSum = new HashSet<>();
        for(int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length -1 ; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if((nums[i] + nums[j] + nums[k]) == 0) {
                        List<Integer> sumOfThree = new ArrayList<>();
                        sumOfThree.add(nums[i]);
                        sumOfThree.add(nums[j]);
                        sumOfThree.add(nums[k]);
                        if(!distinctThreeSum.contains(sumOfThree.toString())) {
                            count.add(sumOfThree);
                            distinctThreeSum.add(sumOfThree.toString());
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a[] = {-1,0,1,2,-1,-4};
//        Arrays.sort(a);
        threeSum(a);
    }
}
