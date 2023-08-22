package leetcode.algorithms;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

//        int[] array = {8,9,2,3,4};
//        int[] array = {8,1,2,3,4,5};
//        int[] array = {4,5,6,7,0,1,2};
        int[] array = {4,5,1,2,3};
        System.out.println(search(array, 1));
    }

    public static int search(int[] nums, int target) {
        if(nums.length == 1 && target == nums[0]) {
            return 0;
        } else if(nums.length == 1 && target != nums[0]) {
            return -1;
        } else if(nums.length == 2 || nums.length == 3) {
            for(int i = 0; i< nums.length; i++) {
                if(nums[i] == target) {
                    return i;
                }
            }
        }



        int startIndex = 0;
        int endIndex = 0;
        if(nums[startIndex] < nums[nums.length -1]) {
            return findNumber(nums, startIndex, nums.length -1, target);
        }

        int centralIndex = (nums.length -1)/2;

        int indexOfMaxNumber = nums.length-1;
        int indexOfMinNumber = 0;
        if(centralIndex > 0 && nums[centralIndex -1] < nums[centralIndex]) {
            while (centralIndex > 0 && nums[centralIndex -1] < nums[centralIndex]) {
                centralIndex--;
            }
            if(centralIndex > 0) {
                indexOfMaxNumber = centralIndex -1;
                indexOfMinNumber = centralIndex;
            }
        } else {

        }

        if (centralIndex < nums.length -1 && nums[centralIndex] < nums[centralIndex + 1]) {
            while (centralIndex < nums.length -1 && nums[centralIndex] < nums[centralIndex + 1]) {
                centralIndex++;
            }
            if(centralIndex < nums.length -1) {
                indexOfMaxNumber = centralIndex;
                indexOfMinNumber = centralIndex + 1;
            }
        }

        if(nums[indexOfMinNumber] <= target && target <= nums[nums.length-1]) {
            startIndex = indexOfMinNumber;
            endIndex = nums.length-1;
        } else if(nums[0] <= target && target <= nums[indexOfMaxNumber]) {
            startIndex = 0;
            endIndex = indexOfMaxNumber;
        } else {
            return -1;
        }

        return findNumber(nums, startIndex, endIndex, target);
    }

    private static int findNumber(int[] nums, int startIndex, int endIndex, int target) {
        while (startIndex <= endIndex) {
            if(nums[startIndex] == target) {
                return startIndex;
            }
            if (nums[endIndex] == target) {
                return endIndex;
            }

            int midIndex = (startIndex + endIndex) / 2;
            if(nums[midIndex] == target) return midIndex;
            else {
                if(nums[midIndex] > target) {
                    endIndex = midIndex -1;
                } else {
                    startIndex = midIndex + 1;
                }
            }
        }
        return -1;
    }

}
