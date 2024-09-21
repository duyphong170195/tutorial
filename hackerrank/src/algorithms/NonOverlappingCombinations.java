package algorithms;

import java.util.ArrayList;
import java.util.List;

public class NonOverlappingCombinations {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        generateNonOverlappingCombinations(array);
    }

    private static void generateNonOverlappingCombinations(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(array, 0, new ArrayList<>(), result);

        // Print the non-overlapping combinations
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }

    private static void backtrack(int[] array, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < array.length; i++) {
            current.add(array[i]);
            backtrack(array, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}