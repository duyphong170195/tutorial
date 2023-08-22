package leetcode.algorithms;

import java.util.*;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        Set<Integer> candidatesExisted = new HashSet<>();
        for(int i = 0; i< candidates.length; i++) {
            candidatesExisted.add(candidates[i]);
        }

        Map<Integer, List<List<Integer>>> keyToListNumbers = new HashMap<>();

        for(int i = 1; i< candidates.length; i++) {
            int key = candidates[i];
            List<List<Integer>> combinationList = new ArrayList<>();
            for(int j = 0 ; j < i; j++) {
                int remainder = key % candidates[j];
                if(remainder == 0 || candidatesExisted.contains(remainder)) {
                    int resultDeviding = key / candidates[j];
                    List<Integer> combinationOfEachNumber = new ArrayList<>();
                    if(remainder != 0) {
                        combinationOfEachNumber.add(remainder);
                    }
                    for(int k = 0; k < resultDeviding; k++) {
                        combinationOfEachNumber.add(candidates[j]);
                    }
                    combinationList.add(combinationOfEachNumber);
                }
            }
            keyToListNumbers.put(key, combinationList);
        }
        for(Map<Integer, List<List<Integer>>> )

            // TODO check
//        for(int m = 0; m < combinationOfEachNumber.size(); m++) {
//            if(keyToListNumbers.containsKey(combinationOfEachNumber.get(i))) {
//                List<List<Integer>> combinationSub =
//                        List<Integer> combinationElements = new ArrayList<>();
//                for(int n = 0; n < combinationOfEachNumber.size(); n++) {
//                    if(n == i) {
//                        combinationElements.addAll(keyToListNumbers.get(i));
//                    } else {
//                        combinationElements.add(combinationOfEachNumber.get(n));
//                    }
//                }
//            }
//        }




        Set<Integer> candidatesSet = new HashSet<>();
        for(int i = 0; i< candidates.length; i++) {
            candidatesSet.add(candidates[i]);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < candidates.length; i++) {
            List<Integer> sum = new ArrayList<>();
            int remainder = target % candidates[i];
            if(remainder == 0) {
                int repeat = target / candidates[i] ;
                sum.addAll(Collections.nCopies(repeat, candidates[i]));
            } else {

            }
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int a[] = {2,3,4,6,7};
        combinationSum(a, 6);
        List<Integer> abc = new ArrayList<>();
        abc.addAll(List.of(2,3,4,6,7));

        abc.toString();

        System.out.println(abc);
    }
}
