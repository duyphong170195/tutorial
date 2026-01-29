package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {

        System.out.println(combine(4, 2));
    }
    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, result, new ArrayList<>(), 1, 1);

        return result;
    }

    private static void backtrack(int n, int k, List<List<Integer>> result, List<Integer> current, int start, int count) {

        if(count == k + 1) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i <= n; i++) {
            current.add(i);
            backtrack(n, k, result, current, i + 1, count + 1);
            current.remove(current.size() - 1); // backtrack
        }
    }
}
