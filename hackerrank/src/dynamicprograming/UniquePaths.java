package dynamicprograming;

public class UniquePaths {
    public static void main(String[] args) {
//        System.out.println(solve(1, 1, 3, 7));

        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {

        return solve(m, n, new int[m+1][n+1]);
    }

    public static int solve(int m, int n, int cache[][]) {
        if (m == 1 && n == 1) {
            cache[1][1] = 1;
            return 1;
        }

        if (cache[m][n] != 0) {
            return cache[m][n];
        }
        int sum = 0;

        if (m > 1) {
            cache[m - 1][n] = solve(m - 1, n, cache);
            sum += cache[m - 1][n];
        }
        if (n > 1) {
            cache[m][n - 1] = solve(m, n - 1, cache);
            sum += cache[m][n - 1];
        }

        return sum;
    }

//    public static int solve(int left, int right, int m, int n, int dp[][]) {
//        int sum = 0;
//
//        if (m == left && n == right) {
//            return 1;
//        }
//        if (left < m) {
//            sum += solve(left + 1, right, m, n);
//        }
//        if (right < n) {
//            sum += solve(left, right + 1, m, n);
//        }
//
//        return sum;
//    }

}

