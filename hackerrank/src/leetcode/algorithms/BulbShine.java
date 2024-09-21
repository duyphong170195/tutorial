package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

public class BulbShine {

    public static int solution(int[] A) {
        int moments = 0;
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            if (max == i + 1) {
                moments++;
            }
        }

        return moments;
    }

    public static void main(String[] args) {
        int[] A1 = {2, 1, 3, 5, 4};
        int result1 = solution(A1);
        System.out.println(result1);  // Output should be 3
        int result5 = solution2(A1);
        System.out.println(result5);  // Output should be 3

        int[] A2 = {1,8,2,9,3,4,7,5,6};
        int result2 = solution(A2);
        System.out.println(result2);  // Output should be 4

        int result3 = solution2(A2);
        System.out.println(result3);  // Output should be 4
    }

    public static int solution2(int[] a) {
        Set<Integer> missing = new HashSet<>();
        Set<Integer> store = new HashSet<>();
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (!store.contains(i + 1) && i + 1 != a[i])
                missing.add(i + 1);
            if (i + 1 < a[i])
                store.add(a[i]);
            else
                missing.remove(a[i]);
            if (missing.isEmpty())
                count++;
        }
        return count;
    }
}