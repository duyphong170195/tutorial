package algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class FormingAMagicSquare {

    // a magic square where the sum of any row, column, is always equal to the same number

    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here

        int[][][] listMagicSquare = {
                {{8,1,6}, {3,5,7}, {4,9,2}},
                {{6,1,8}, {7,5,3}, {2,9,4}},
                {{4,9,2}, {3,5,7}, {8,1,6}},
                {{2,9,4}, {7,5,3}, {6,1,8}},
                {{8,3,4}, {1,5,9}, {6,7,2}},
                {{4,3,8}, {9,5,1}, {2,7,6}},
                {{6,7,2}, {1,5,9}, {8,3,4}},
                {{2,7,6}, {9,5,1}, {4,3,8}},
        };
        int minimumSum = 0;
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        for(int i = 0; i < listMagicSquare.length; i++) {
            for(int j = 0; j < listMagicSquare[i].length; j++) {
                List<Integer> magicSquare = s.get(j);
                for(int k = 0; k < listMagicSquare[i][j].length; k++) {
                    minimumSum += Math.abs(listMagicSquare[i][j][k] - magicSquare.get(k));
                }
            }
            treeMap.put(minimumSum, "");
            minimumSum = 0;
        }

        return treeMap.firstKey();
    }

    public static void main(String[] args) {
        List<List<Integer>> s  = Arrays.asList(Arrays.asList(5,3,4), Arrays.asList(1,5,8), Arrays.asList(6,4,2));
        List<List<Integer>> s2  = Arrays.asList(Arrays.asList(5,3,4), Arrays.asList(1,5,8), Arrays.asList(6,4,2));
        System.out.println(formingMagicSquare(s));
    }
}
