package dynamicprogramming;

public class LongestPalindromicSubstring {
    /*
        solution link: https://leetcode.com/problems/longest-palindromic-substring/solutions/4212564/beats-96-49-5-different-approaches-brute-force-eac-dp-ma-recursion/
    */
    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); ++i) {
            // danh giau bat dau la vi tri giua
            dp[i][i] = true;
            for (int j = 0; j < i; ++j) {
                // why i - j <= 2 ?

                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    // i - j + 1 phai lon hon previous maxLen để lấy ra chuỗi Palindrome dài nhất
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String a = "abcdertredfew";
//        7 - 5
        longestPalindrome(a);
    }
}