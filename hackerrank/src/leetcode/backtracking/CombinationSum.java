package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        if(sum > target) return;

        for(int i = start; i < candidates.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            temp.add(candidates[i]);
            backTracking(candidates, target,result, temp, sum + candidates[i], i);
        }
    }

}
