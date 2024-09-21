package dynamicprograming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumPathSum {

    public static void main(String[] args) {
        int a[][] = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(
                minPathSum(a)
        );

    }
    /*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
    Note: You can only move either down or right at any point in time.
     */
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the first row of dp with grid values
        for (int i = 1; i <= n; i++) {
            dp[1][i] = grid[0][i - 1] + dp[1][i - 1];
        }

        // Initialize the first column of dp with grid values
        for (int j = 1; j <= m; j++) {
            dp[j][1] = grid[j - 1][0] + dp[j - 1][1];
        }

        // Fill the dp table with minimum path sums
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = grid[i - 1][j - 1] + Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        // Return the result from the bottom-right corner
        return dp[m][n];
    }
}
