package leetcode.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingDilemma {


    public static long carParkingRoof(List<Long> cars, int k) {
        Collections.sort(cars);
        long shortCover = cars.get(k-1) - cars.get(0);
        System.out.println(shortCover);
        for(int i = k; i< cars.size(); i++) {
            shortCover = Math.min(shortCover,  cars.get(i) - cars.get(i-k));
            System.out.println(shortCover);
        }
        return shortCover +1;
    }

    public static long carParkingRoof2(List<Long> cars, int k) {
        // Write your code here
        if (cars.size() == 0 || k < 0) {
            return 0;
        }

        Collections.sort(cars);
        System.out.println(cars);
        long minDist = Long.MAX_VALUE;
        for (int i = 0; i <= cars.size() - k; i++) {
            System.out.println("i= " + cars.get(i + k - 1));
            System.out.println("i + k - 1= " + cars.get(i));
            minDist = Math.min(minDist, cars.get(i + k - 1) - cars.get(i));
            System.out.println(minDist);
        }

        return minDist + 1;
    }

    // đếm số lần khi bật công tắc đèn tại đèn đó có thể sáng
    public static long bulbs(List<Long> bulbs) {
        int count = 0;
        for(int i = 0; i< bulbs.size(); i++) {
            if (bulbs.get(i) - i  == 1 || bulbs.get(i) - i  == 0) {
                count++;
                System.out.println(i);
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(carParkingRoof(Arrays.asList(10L,2L,3L,8L), 3));
        bulbs(Arrays.asList(2L,1L,3L,5L,4L));
//        System.out.println(carParkingRoof2(Arrays.asList(10L,2L,3L,11L, 12L, 14L, 17L), 4));
    }
}
