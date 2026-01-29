package leetcode.study_plan;

public class BestTimeToBuySellStockII {

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};

        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int j = 0;
        int i = 1;
        while(i < prices.length) {
            if(prices[j] < prices[i]) {
                maxProfit += prices[i] - prices[j] ;
            }
            i++;
            j++;
        }
        return maxProfit;
    }

}
