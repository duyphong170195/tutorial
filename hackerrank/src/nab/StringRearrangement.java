package nab;

public class StringRearrangement {

    public static void main(String[] args) {
        System.out.println(solution("BAAABAB"));
    }

    public static int solution(String s) {
        int n = s.length();
        int[] countA = new int[n + 1];
        int[] countB = new int[n + 1];

        // Count number of 'A's from the right to left
        for (int i = n - 1; i >= 0; i--) {
            countA[i] = countA[i + 1] + (s.charAt(i) == 'A' ? 1 : 0);
        }

        // Count number of 'B's from the left to right
        for (int i = 1; i <= n; i++) {
            countB[i] = countB[i - 1] + (s.charAt(i - 1) == 'B' ? 1 : 0);
        }

        // Now calculate the minimum deletions required at each point
        int minDeletions = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            // Minimum deletions is sum of 'B's on the left + 'A's on the right
            minDeletions = Math.min(minDeletions, countB[i] + countA[i]);
        }

        return minDeletions;
    }
}
