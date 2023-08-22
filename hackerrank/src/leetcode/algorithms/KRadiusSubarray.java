package leetcode.algorithms;

import java.math.BigDecimal;
import java.math.BigInteger;

public class KRadiusSubarray {

    public int[] getAverages(int[] nums, int k) {
        if(nums.length == 1 && k ==0 ) {
            return nums;
        }

        int result[] = new int[nums.length];
        if(nums.length < (k * 2 + 1)) {
            for(int i = 0 ; i< nums.length; i++) {
                result[i] = -1;
            }
            return result;
        }

        long sum = 0;
        int windowSize = k*2;
        for(int i = 0; i <= windowSize ; i++) {
            sum += nums[i];
            result[i] = -1;
        }
        int numberToDivide = (k * 2 + 1);
        long temp = sum/numberToDivide;
        result[k] = (int)temp;
        int start = 0;
        int end = windowSize + 1;
        for(int i = k+1; i < nums.length - k; i++) {
            sum = sum + nums[end] - nums[start];
            temp = sum/numberToDivide;
            result[i] = (int)temp;
            start++;
            end++;

        }

        for(int i = nums.length - k; i < nums.length; i++) {
            result[i] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
//        int array[] = {7,4,3,9,1,8,5,2,6};
//
//        int result[] = getAverages(array, 3);
//
//        for(int i = 0; i< result.length; i++) {
//            System.out.println(result[i]);
//        }
//        System.out.println(
//                getAverages(array, 3)
//        );
    }
}
