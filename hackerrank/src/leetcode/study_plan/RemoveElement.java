package leetcode.study_plan;

import java.util.Arrays;

public class RemoveElement {


    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};

        removeElement2(nums, 2);

        System.out.println(nums);
    }

    public static int removeElement2(int[] nums, int val) {
        int k = 0; // Points to the position to store the next non-val element

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static int removeElement(int[] nums, int val) {

        if(nums.length == 0) return 0;
        int k = nums.length;
        int i = k-1;
        while ( i >= 0 ) {
            if(nums[i] == val && i == nums.length -1) {
                nums[i] = 1000;
                k--;
            } else if(nums[i] == val) {
                for(int j = i; j < nums.length -1; j++) {
                    nums[j] = nums[j+1];
                }
                k--;
            }
            i--;
        }
        if( 0 == k) return k;
        sort(nums, 0, k-1);

        return k;
    }

    private static void sort(int[] nums, int left, int right) {
        int mid = (right + left )/2;
        if(left == right) return;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);

        // merge

        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] array1 = new int[n1];
        int[] array2 = new int[n2];

        for(int i = 0; i < array1.length; i++) {
            array1[i] = nums[left + i];
        }

        for(int i = 0; i < array2.length; i++) {
            array2[i] = nums[mid + i + 1];
        }

        int m = 0, n = 0;
        int k = left;
        while(m < array1.length && n < array2.length) {
            if(array1[m] < array2[n]) {
                nums[k++] = array1[m];
                m++;
            } else {
                nums[k++] = array2[n];
                n++;
            }
        }

        while( m < array1.length) {
            nums[k++] = array1[m];
            m++;
        }

        while( n < array2.length) {
            nums[k++] = array2[n];
            n++;
        }
    }

}

