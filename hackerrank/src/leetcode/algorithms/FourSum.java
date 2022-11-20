package leetcode.algorithms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

    public static void main(String[] args) {

        int a[] ={-2,-1,-1,1,1,2,2};
        fourSum(a, 0);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        Set<String> distinctThreeSum = new HashSet<>();
        for(int i = 0; i < nums.length - 3; i++) {
            // trường hợp i bị trùng với i -1
            if((i != 0) && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j< nums.length - 2; j++) {
                // check mỗi lần khi tăng i
                // khi i tăng thì có thể giá trị của i thay đổi
                // nhưng giá trị của j thì ko thay đổi vì j dựa theo i
                // nên chúng ta có câu lệnh j != i + 1
                if((j != i+ 1) && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int m = nums.length -1;
                while (k < m) {
                    List<Integer> result = new ArrayList<>();
                    BigInteger sum;
                    sum = BigInteger.valueOf(nums[i])
                            .add(BigInteger.valueOf(nums[j]))
                            .add(BigInteger.valueOf(nums[k]))
                            .add(BigInteger.valueOf(nums[m]));

                    if(sum.compareTo(BigInteger.valueOf(target)) == 0) {
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        result.add(nums[m]);
                        if(!distinctThreeSum.contains(result.toString())) {
                            distinctThreeSum.add(result.toString());
                            results.add(result);
                        }
                        k++;
                        m--;

                        while ((k < m) && (nums[m] == nums[m+1]))
                            m--;
                        while ((k < m) && (nums[k] == nums[k-1]))
                            k++;
                    }
                    // Loai bo truong hop same value
                     else if(sum.compareTo(BigInteger.valueOf(target)) > 0) {
                            m--;
                    }
                    // Loai bo truong hop same value
                     else {
                        k++;
                    }

                }
            }
        }
        System.out.println(results);
        return results;
    }

    /**
     * -2, -2, -2, 0, 1, 2
     * i=0, j=1, k=2,    m = 5
     * -2, -2, -2, 2
     * -2, -2, 0, 2
     * -2, -2, 1, 2
     * i=0, j=2, k=3,    m = 5
     * -2, -2, 0, 2
     * -2, -2, 1, 2
     *
     */
}
