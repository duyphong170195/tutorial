package leetcode.twopointers;

public class RemoveDuplicates {


    public static void main(String[] args) {
//        int[] arr = {1,1,1,2,2,3};
        int[] arr = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(arr));
    }
    public static int removeDuplicates(int[] nums) {
        int current = nums[0];
        int countCurrent = 1;
        int length = 1;
        int redundantCount = 0;
        int totalRedundantCount = 0;
        for(int i =1 ; i< nums.length-1; i++) {
            if (nums[i] == current && countCurrent < 2) {
                countCurrent++;
                length++;
            }  else if (nums[i] == current && countCurrent >=2 ) {
                totalRedundantCount++;
                redundantCount++;
            } else if (nums[i] != current && countCurrent >=2) {
                totalRedundantCount++;
                redundantCount++;
            } else {
                current = nums[i];
                countCurrent = 1;
                length++;
            }
        }
        return length;
    }

    public int removeDuplicates3(int[] nums) {
        // If the array length is less than or equal to 2, return the length since no duplicates can exceed twice
        if (nums.length <= 2) {
            return nums.length;
        }

        // Start with the third element
        int index = 2;

        // Iterate through the array starting from the third element
        for (int i = 2; i < nums.length; i++) {
            // If the current element is not the same as the element two positions before it,
            // then it means it can be added since it won't cause more than 2 duplicates
            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }

        // Return the length of the modified array
        return index;
    }
}
