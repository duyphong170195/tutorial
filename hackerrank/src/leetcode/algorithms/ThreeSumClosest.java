package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSumClosest {

    public static void main(String[] args) {
        int nums[] = {1,1,1,1};
        System.out.println(threeSumClosest(nums, 0));
    }

    public static int threeSumClosest(int[] nums, int target) {
        // list all three sum
        // sort three sum
        // use binary search to find
        List<Integer> sumThree = new ArrayList();
        int lengthOfNumArray = nums.length;
        for(int i = 0; i < lengthOfNumArray - 2; i++) {
            for(int j = i+1; j < lengthOfNumArray - 1; j++) {
                for(int k = j+1; k < lengthOfNumArray; k++) {
                    sumThree.add(nums[i]+ nums[j] + nums[k]);
                }
            }
        }

        Collections.sort(sumThree);
        List<Integer> numbers = locateNumberInRange(sumThree, 0, sumThree.size() -1 , target);
        if(numbers.size() == 1) {
            return numbers.get(0);
        } else {
            if(Math.abs(target - numbers.get(0)) > Math.abs(target - numbers.get(1))) {
                return numbers.get(1);
            } else {
                return numbers.get(0);
            }
        }
    }

    public static List<Integer> locateNumberInRange(List<Integer> numbers, int l, int r, int number) {

        int middle = l + (r - l) / 2;
        // truong hop trong range
        // truong hop
        if(l == r && r == middle) {
            List<Integer> arrayNumbers = new ArrayList<>();
            arrayNumbers.add(numbers.get(middle));

            return arrayNumbers;
        }

        if((middle -1 >= 0) &&((number >= numbers.get(middle-1) && number < numbers.get(middle))
                || (number > numbers.get(middle-1) && number <= numbers.get(middle)))) {
            List<Integer> arrayNumbers = new ArrayList<>();
            arrayNumbers.add(numbers.get(middle-1));
            arrayNumbers.add(numbers.get(middle));
            return arrayNumbers;
        }

        if((middle + 1) < numbers.size()  &&
                (  (number >= numbers.get(middle) && number < numbers.get(middle+1))
            || (number > numbers.get(middle) && number <= numbers.get(middle+1)))) {
            List<Integer> arrayNumbers = new ArrayList<>();
            arrayNumbers.add(numbers.get(middle));
            arrayNumbers.add(numbers.get(middle+1));
            return arrayNumbers;
        }

        // number = 20
        if(number >  numbers.get(middle)) {
            return locateNumberInRange(numbers, middle + 1, r, number);
        } else {
            return locateNumberInRange(numbers, l, middle, number);
        }
    }

    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[nums.length - 1];

        for(int i = 0; i < nums.length - 2 ; i++) {
            int j = i +1;
            int k = nums.length -1;
            while (j<k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == target) {
                    return sum;
                }

                if(Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                if(sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return closest;
    }
}
