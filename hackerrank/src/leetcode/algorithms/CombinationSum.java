package leetcode.algorithms;

import java.util.*;

public class CombinationSum {

//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//
//        Set<Integer> candidatesExisted = new HashSet<>();
//        for(int i = 0; i< candidates.length; i++) {
//            candidatesExisted.add(candidates[i]);
//        }
//
//        TreeMap<Integer, List<List<Integer>>> keyToListNumbers = new TreeMap<>();
//
//        for(int i = 1; i< candidates.length; i++) {
//            int key = candidates[i];
//            List<List<Integer>> combinationList = new ArrayList<>();
//            for(int j = i-1 ; j >= 0; j--) {
//                int remainder = key % candidates[j];
//                if(remainder == 0 || candidatesExisted.contains(remainder)) {
//                    int resultDeviding = key / candidates[j];
//                    List<Integer> combinationOfEachNumber = new ArrayList<>();
//                    if(remainder != 0) {
//                        combinationOfEachNumber.add(remainder);
//                    }
//                    for(int k = 0; k < resultDeviding; k++) {
//                        combinationOfEachNumber.add(candidates[j]);
//                    }
//                    combinationList.add(combinationOfEachNumber);
//
//                    if(keyToListNumbers.containsKey(candidates[j])) {
//
//
//
//
//                        List<List<Integer>> combinationsOfSumOfKey =  keyToListNumbers.get(candidates[j]);
//                        for(int m = 0; m < combinationOfEachNumber.size(); m++) {
//                            if(keyToListNumbers.containsKey(combinationOfEachNumber.get(i))) {
//                                    List<Integer> combinationElements = new ArrayList<>();
//
//                                for(int n = 0; n < combinationOfEachNumber.size(); n++) {
//                                    if(n == i) {
//                                        combinationElements.addAll(keyToListNumbers.get(i));
//                                    } else {
//                                        combinationElements.add(combinationOfEachNumber.get(n));
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//
//
//            }
//            keyToListNumbers.put(key, combinationList);
//
//
//        }
//
//        Set<Integer> candidatesSet = new HashSet<>();
//        for(int i = 0; i< candidates.length; i++) {
//            candidatesSet.add(candidates[i]);
//        }
//        List<List<Integer>> result = new ArrayList<>();
//        for(int i = 0; i < candidates.length; i++) {
//            List<Integer> sum = new ArrayList<>();
//            int remainder = target % candidates[i];
//            if(remainder == 0) {
//                int repeat = target / candidates[i] ;
//                sum.addAll(Collections.nCopies(repeat, candidates[i]));
//            } else {
//
//            }
//        }
//
//        return new ArrayList<>();
//    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        for(int i = 0; i < candidates.length; i++) {
            recursion(new ArrayList<>(List.of(candidates[i])), candidates, i, target, results);
        }

        return results;
    }

    public static void recursion(List<Integer> combination, int[] candidates, int startIndex, int target, List<List<Integer>> results) {
        int sum = combination.stream().mapToInt(Integer::intValue)
                .sum();

        if(sum > target) {
            return;
        }

        if(sum == target) {
            results.add(combination);
            return;
        }


        for(int i = startIndex; i < candidates.length; i++) {
            List<Integer> newArray = new ArrayList<>();
            newArray.addAll(combination);
            newArray.add(candidates[i]);

            recursion(newArray, candidates, startIndex, target, results);
        }
    }

    public static void main(String[] args) {


        int a[] = {2,3,4,6,7, 9};


        List<List<Integer>> results = combinationSum2(a, 13);
//        combinationSum(a, 6);
//        List<Integer> abc = new ArrayList<>();
//        abc.addAll(List.of(2,3,4,6,7));
//
//        abc.toString();

        System.out.println(results);
    }
}
