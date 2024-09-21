package dynamicprograming;

/*
* You are given an integer array nums. You are initially positioned at the array's first index,
*  and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

* */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class JumpGame {

    public static boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        for(int i = 0; i < nums.length; i++) {

            if(nums[i] == 0) return false;
            int a=  solve(nums, i, nums[i]);
            if (a == -1) return true;
            i = a;
        }
        return false;
    }

    public static int solve(int[] nums, int currentIndex, int value) {
        if(nums[currentIndex] + currentIndex >= nums.length - 1) return -1;
        int lastIndex = currentIndex;
        for(int i = currentIndex + 1; i <= currentIndex + value; i++) {
            System.out.println("====================================== i = " + i);
            if(nums[i] == 0) continue;
            int a = solve(nums, i, nums[i]);
            if (a == -1) return -1;
            lastIndex = i;
        }
        return lastIndex;
    }

    public static void main(String[] args) {

        System.out.println(canJump(loadData()));
    }

    public static int[] loadData() {
        String filePath = "/home/phongnd13/Documents/numbers.txt"; // Replace with the path to your file
        int[] numbersArray = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Read the entire line
            if (line != null) {
                String[] parts = line.split(","); // Split by comma
                numbersArray = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    numbersArray[i] = Integer.parseInt(parts[i].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbersArray;
    }

}
