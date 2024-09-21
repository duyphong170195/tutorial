package dynamicprogramming;

public class minPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};

        System.out.println(minPathSum(grid));
    }

    // https://leetcode.com/problems/minimum-path-sum/solutions/5289179/easy-c-solution-dp-beats-100/
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the first row of dp with grid values
        for (int i = 1; i <= n; i++) {
            dp[1][i] = grid[0][i - 1] + dp[1][i - 1];  // dp[1][1->3] =  grid[0][0->2] + dp[1][0->2]
        }

        // Initialize the first column of dp with grid values
        for (int j = 1; j <= m; j++) {
            dp[j][1] = grid[j - 1][0] + dp[j - 1][1]; // dp[1->3][1] = grid[0->2][0] + dp[0->2][1]
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
