package leetcode.study_plan;

import dynamicprogramming.MaximumSubarray;

public class BestTimeToBuySellStock {

    public static void main(String[] args) {
        int nums[] = {1,7,1,5,3,6,4};

        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int j = 0;
        for(int i = 1; i < prices.length; i++) {

            if(prices[j] > prices[i]) {
                j = i;
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - prices[j]) ;
            }
        }
        return maxProfit;
    }

}
