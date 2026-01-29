package leetcode.study_plan;

public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
//        int nums[] = {0,0,1,1,1,2,2,3,3,4};
        int nums[] = {1,1,1,2,2,2,3,3};
//        int nums[] = {1,2,2};
//        int nums[] = {1,1, 1, 1};

        System.out.println(removeDuplicates(nums));
        System.out.println();
    }

    public static int solve(int[] nums) {
        int right =0;
        int left = 0;
        int idx = 1;

        while(idx < nums.length) {
            if(nums[right] == nums[idx]) {

                idx++;
            }



            if(nums[right] != nums[idx] ) {
                nums[right]= nums[idx];
                right++;
            }

            idx++;
        }

        return  right + 1 ;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int insertPos = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[insertPos - 2]) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        return insertPos;
    }
}
