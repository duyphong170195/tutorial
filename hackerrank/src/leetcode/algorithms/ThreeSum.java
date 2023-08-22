package leetcode.algorithms;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> count = new ArrayList<>();
        Set<String> distinctThreeSum = new HashSet<>();
        for(int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length -1 ; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if((nums[i] + nums[j] + nums[k]) == 0) {
                        List<Integer> sumOfThree = new ArrayList<>();
                        sumOfThree.add(nums[i]);
                        sumOfThree.add(nums[j]);
                        sumOfThree.add(nums[k]);
                        if(!distinctThreeSum.contains(sumOfThree.toString())) {
                            count.add(sumOfThree);
                            distinctThreeSum.add(sumOfThree.toString());
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a[] = {-1,0,1,2,-1,-4};
//        Arrays.sort(a);
        threeSum(a);

//        Calendar calendar = Calendar.getInstance();
//        calendar.clear();
//        calendar.setTimeInMillis(System.currentTimeMillis());
//        while (calendar.get(Calendar.DAY_OF_WEEK) > calendar.getFirstDayOfWeek()) {
//            calendar.add(Calendar.DATE, -1); // Substract 1 day until first day of week.
//        }
//        long firstDayOfWeekTimestamp = calendar.getTimeInMillis();
//        System.out.println(firstDayOfWeekTimestamp);

        Calendar calobj = Calendar.getInstance();
        System.out.println("first day of current week:"
                + calobj.getFirstDayOfWeek());

        calobj.add(Calendar.YEAR, 1996);
        calobj.add(Calendar.MONTH, 9);
        calobj.add(Calendar.DAY_OF_WEEK, 23);

        System.out.println("If date is  " + calobj.getTime() + "  then first day of week is  "
                + calobj.getFirstDayOfWeek());

        calobj.setFirstDayOfWeek(Calendar.TUESDAY);
        System.out.println("now first day of week :"
                + calobj.getFirstDayOfWeek());
    }
}
