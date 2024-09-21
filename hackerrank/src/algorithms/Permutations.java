package algorithms;

import java.util.Arrays;

public class Permutations {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        generatePermutations(array, 0);
    }

    private static void generatePermutations(int[] array, int index) {
        if (index == array.length - 1) {
            System.out.println(Arrays.toString(array));
            return;
        }

        for (int i = index; i < array.length; i++) {
            // Swap the current element with the element at index
            swap(array, index, i);

            // Recursively generate permutations for the remaining elements
            generatePermutations(array, index + 1);

            // Undo the swap to backtrack
            swap(array, index, i);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
