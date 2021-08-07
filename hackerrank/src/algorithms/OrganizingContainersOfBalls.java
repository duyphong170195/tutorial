package algorithms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrganizingContainersOfBalls {
    // Each container contains only balls of the same type.
    // No two balls of the same type are located in different containers.

    // check type of balls that are enough or not
    // For each query, print Possible on a new line if David can satisfy the conditions above for the given matrix. Otherwise, print Impossible.



    public static void main(String[] args) {
//         test case 1
//        List<Integer> c1 = Arrays.asList(0, 2, 1);
//        List<Integer> c2 = Arrays.asList(1, 1, 1);
//        List<Integer> c3 = Arrays.asList(2, 0, 0);
        // test case 2
//        List<Integer> c1 = Arrays.asList(1, 4);
//        List<Integer> c2 = Arrays.asList(2, 3);
        // test case 3
//        List<Integer> c1 = Arrays.asList(1, 3, 1);
//        List<Integer> c2 = Arrays.asList(2, 1, 2);
//        List<Integer> c3 = Arrays.asList(3, 3, 3);

         //test case4
//        List<Integer> c1 = Arrays.asList(999789250, 999886349);
//        List<Integer> c2 = Arrays.asList(999654053, 999789250);
//        List<Integer> c1 = Arrays.asList(46243313, 92616295, 67710591, 64815435, 54972858, 72243452, 43981963, 98839842);
//        List<Integer> c2 = Arrays.asList(92051933, 89794374, 13448199, 23493279, 82268795, 11069706, 82550576, 19654929);
//        List<Integer> c3 = Arrays.asList(81743395, 56456242, 80407875, 99464396, 95594850, 44919631, 12483256, 54576390);
//        List<Integer> c4 = Arrays.asList(31379865, 35550507, 13850344, 82310457, 35039216, 11977132, 44906966, 58819635);
//        List<Integer> c5 = Arrays.asList(10544893, 81324309, 69520528, 81983330, 45347555, 78383273, 77715274, 86346533);
//        List<Integer> c6 = Arrays.asList(78482611, 37125744, 47756688, 70062813, 86629089, 81735741, 38208033, 80479682);
//        List<Integer> c7 = Arrays.asList(59164275, 5441347, 85517562, 78736923, 59124243, 51404960, 24474089, 27179427);
//        List<Integer> c8 = Arrays.asList(48097170, 61680833, 13467922, 1371525, 59776803, 85694885, 96662368, 52983154);

        List<Integer> c1 = Arrays.asList(990446736,997114107,981378365,996304832);
        List<Integer> c2 = Arrays.asList(998069384,997117556,999915673,983059005);
        List<Integer> c3 = Arrays.asList(977726971,997275340,996964137,999686661);
        List<Integer> c4 = Arrays.asList(999000949,999267170,999903443,992602611);
        List<List<Integer>> containers = Arrays.asList(c1, c2, c3, c4);
//        int [][]a = new int[containers.size()][containers.size()];
//        for(int i = 0; i < containers.size(); i++)
//            for(int j = 0; j< containers.size(); j++)
//                a[i][j] =containers.get(i).get(j);

        System.out.println(organizingContainers(containers));
    }
    public static String organizingContainers(List<List<Integer>> container) {
        List<Long> sumOfDifferentTypeOfBallInEachContainers = new ArrayList<>();
        List<Long> sumOfSameTypeBallsInColumns = new ArrayList<>();
        for( int i = 0; i< container.size(); i++) {
            long capacityOfEachBox = 0;
            long totalQuantityOfEachBallType = 0;
            for(int j = 0; j < container.size(); j++) {
                capacityOfEachBox += container.get(i).get(j);
                totalQuantityOfEachBallType += container.get(j).get(i);
            }
            sumOfDifferentTypeOfBallInEachContainers.add(capacityOfEachBox);
            sumOfSameTypeBallsInColumns.add(totalQuantityOfEachBallType);
        }
        Collections.sort(sumOfDifferentTypeOfBallInEachContainers);
        Collections.sort(sumOfSameTypeBallsInColumns);

        for(int i = 0; i < container.size(); i++) {
            if(sumOfDifferentTypeOfBallInEachContainers.get(i).equals(sumOfSameTypeBallsInColumns.get(i)) == false) {
                return "Impossible";
            }
        }
        return "Possible";
    }

//    static String organizingContainers(int[][] container) {
//
//        //array to count amount amount of each ball, it's position is a type and value the amount
//        int[] ballsCount = new int[container[0].length];
//
//        //array to count how many balls are currently in each basket
//        int[] basketCapacity = new int[container[0].length];
//
//        //iterate through every array and then every value in it
//        for(int i = 0; i < container.length; i++){
//            for(int j = 0; j < container.length; j++){
//                basketCapacity[i] += container[i][j];
//                ballsCount[j] += container[i][j];
//            }
//        }
//
//        Arrays.sort(ballsCount);
//        Arrays.sort(basketCapacity);
//
//
//        if(Arrays.equals(ballsCount, basketCapacity)){
//            return "Possible";
//        }else{
//            return "Impossible";
//        }
//
//    }


//    public static String organizingContainers(List<List<Integer>> container) {
//        int[] sumOfBallTypesOfEachColumn = new int[container.size()];
//        int row = 0;
//        for( int i = 0; i< container.size(); i++) {
//            for(int j  = 1; j < container.size(); j++) {
//                sumOfBallTypesOfEachColumn[i] = sumOfBallTypesOfEachColumn[i] + container.get(row).get(i);
//                row ++;
//            }
//            row = 0;
//            if(sumOfBallTypesOfEachColumn[i] > container.size()) {
//                return "Impossible";
//            }
//        }
//        return "Possible";
//    }
}
