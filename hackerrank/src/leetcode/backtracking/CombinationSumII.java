package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
//        int[] candidates = {2, 2, 2};
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates, target);
        List<List<Integer>> result2 = newCombinationSum2(candidates, target);
        System.out.println(result);
    }


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        backTracking(candidates, target, result, new ArrayList<>(), 0, 0);

        return result;
    }

    public static void backTracking(int[] candidates, int target, List<List<Integer>> result, List<Integer> list, int sum, int start) {
        if(sum == target) {
            result.add(list);
            return;
        }


        for(int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // If the current candidate exceeds the target, break the loop
            if (sum + candidates[i] > target) break;


            List<Integer> temp = new ArrayList<>();

            temp.addAll(list);
            temp.add(candidates[i]);
            System.out.println(temp);
            backTracking(candidates, target,result, temp, sum + candidates[i], i + 1);
        }
    }


    public static List<List<Integer>> newCombinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort the array to handle duplicates
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Found a valid combination
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicate elements
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // If the current candidate exceeds the target, break the loop
            if (candidates[i] > target) break;

            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, current, result); // Move to the next element
            current.remove(current.size() - 1); // Backtrack
        }
    }
}
