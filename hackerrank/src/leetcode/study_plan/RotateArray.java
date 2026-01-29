package leetcode.study_plan;

public class RotateArray {

    public static void main(String[] args) {
//        int nums[] = {1,2,3,4,5,6,7};
        int nums[] = {-1,-100,3,99};

        rotate(nums, 2);

    }

    public static void rotate(int[] nums, int k) {

        int length = nums.length;
        if(k == 0 || length == 1 || k == length) return;

        int realRotate = k > length ? k % length : k;


        int temp[] = new int[realRotate];

        for(int i = 0; i< temp.length; i++) {
            temp[temp.length - realRotate + i] = nums[length - realRotate + i];
        }

        for(int i = 0; i < length - realRotate; i++) {
            nums[length - i -1] = nums[length - realRotate - i - 1];
        }

        for(int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
    }
}
