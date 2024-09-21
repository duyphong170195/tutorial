package leetcode.algorithms;

public class BulbShine {

    public static int solution(int[] A) {
        int moments = 0;
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            if (max == i + 1) {
                moments++;
                System.out.println("result = " + (i));
            }
        }

        return moments;
    }

    public static void main(String[] args) {
        int[] A1 = {2, 1, 3, 5, 4};
        int result1 = solution(A1);
        System.out.println(result1);  // Output should be 3

        int[] A2 = {3, 1, 4, 2, 5};
        int result2 = solution(A2);
        System.out.println(result2);  // Output should be 4
        // off off on off off
        // on off on off off // 1
        // on off on on off
        // on on on on off // 2
        // on on on on on // 3
    }
}