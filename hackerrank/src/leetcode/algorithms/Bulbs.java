package leetcode.algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class Bulbs {
    public static int bulbs(List<Integer> inputData) {
        List<Integer> turnedOnBulbs = new ArrayList<>();
        List<Integer> sortedBulbs = inputData.stream().parallel().sorted().collect(Collectors.toList());

        int indexSortedBulbs = 0;
        int count = 0;
        for(int i= 0; i< inputData.size(); i++) {
            turnedOnBulbs.add(0);
        }

//        for(int i = 0; i < inputData.size(); i++) {
//            if(turnedOnBulbs.contains(sortedBulbs.get(indexSortedBulbs))) {
//                indexSortedBulbs ++;
//            }
//            turnedOnBulbs.add(inputData.get(i));
//            for(int  )
//            if(Objects.equals(inputData.get(i), sortedBulbs.get(indexSortedBulbs))) {
//                indexSortedBulbs ++;
//                count ++;
//            }
//        }
        if(Objects.equals(sortedBulbs.get(sortedBulbs.size() -1), inputData.get(inputData.size() -1))) {
            count ++;
        }
        return count;
    }


    public static void main(String[] args) {
//        [7, 3, 5, 4, 1, 6, 2]
        System.out.println(bulbs(Arrays.asList(7, 3, 5, 4, 1, 6, 2)));
//        solve(Arrays.asList(7,6,5,4,3,2,1));

    }

    public static int solve(List<Integer> inputData) {
        List<Integer> sortedInputData = inputData.stream().parallel().collect(Collectors.toList());
        Set<Integer> turnedOnBulbs = new HashSet<>();
        int indexSortedBuld = 0;
        int count = 0;
        // Write your code here
        for(int i =0; i< inputData.size(); i++) {
            if(turnedOnBulbs.contains(sortedInputData.get(indexSortedBuld))) {
                indexSortedBuld++;
            }
            turnedOnBulbs.add(inputData.get(i));
            if(Objects.equals(inputData.get(i), sortedInputData.get(indexSortedBuld))) {
                indexSortedBuld++;
                count++;
            }
        }
        System.out.println(count);
        return count;

    }
}
