package smilegate;

import java.util.Arrays;
import java.util.List;

public class HackerJumpATM {

    public static int gainMaxValue(List<Integer> security_val, int k) {
        // Write your code here
        int n = security_val.size();
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MIN_VALUE);

        int maxSum = Integer.MIN_VALUE;

        for(int i = n-1; i>=0; i--) {
            if(i+k >=n) {
                dp[i] = security_val.get(i);
            } else {
                dp[i] = security_val.get(i) + dp[i+k];
            }

            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    public static int gainMaxValue2(List<Integer> security_val, int k) {
        int n = security_val.size();
        int maxSum = Integer.MIN_VALUE;

        // Try each ATM machine as a starting point
        for (int start = 0; start < n; start++) {
            int currentSum = 0;
            int i = start;

            // Jump through the ATM machines and calculate the sum
            while (i < n) {
                currentSum += security_val.get(i);
                i += k;  // Jump to the next ATM machine
            }

            // Update the maximum sum if the current sum is larger
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }


    public static void main(String[] args) {
        List<Integer> list =
//                List.of(-1,-2,3,4);
                List.of(3,4, -1,-2);
        System.out.println(gainMaxValue(list, 2));
        System.out.println(gainMaxValue2(list, 2));
    }
}
