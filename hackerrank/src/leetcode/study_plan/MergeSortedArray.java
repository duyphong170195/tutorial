package leetcode.study_plan;

public class MergeSortedArray {

    public static void main(String[] args) {
//        int[] a = {9,8,7,6,5,4,3,2,1};
//
//        sort(a, 0, a.length-1);
//        System.out.println();

//        int[] b = {1,8,2,9,3,4,5};
//
//        solve(b, 3);
        int nums1[] = new int[1];
        int nums2[] = new int[1];
        nums2[0] = 1;
//        int nums1[] = {1,2,3,0,0,0};
//        int nums2[] = {2,5,6};

        merge(nums1, 0, nums2, 1);

        System.out.println(nums1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0) {
            for(int i = 0; i< n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int temp[] = new int[m];
        for(int i = 0; i < m; i++) {
            temp[i] = nums1[i];
        }

        int index1 = 0;
        int index2 = 0;
        int i = 0;
        while(index1 < temp.length && index2 < nums2.length) {
            if(temp[index1] < nums2[index2]) {
                nums1[i] = temp[index1];
                index1 ++;
            } else {
                nums1[i] = nums2[index2];
                index2 ++;
            }
            i++;
        }

        for(;index1 < temp.length; index1++) {
            nums1[i] = temp[index1];
            i++;
        }

        for(;index2 < nums2.length; index2++) {
            nums1[i] = nums2[index2];
            i++;
        }
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






    public static void solve(int[] a, int k) {
        int subArray[] = new int[k];

        for(int i = 0; i < a.length ; i++) {
            swap(a[i], subArray);
        }
        System.out.println(subArray[0]);
    }

    private static void swap(int element, int[] subArray) {
        int lastIndex = subArray.length -1;
        if(element > subArray[lastIndex]) {
            int temp = element;
            int j = 0;
            while( j < lastIndex) {
                subArray[j] = subArray[j+1];
                j++;
            }


            subArray[lastIndex] = temp;
        }else {

            for(int i = subArray.length-1; i >=0; i--) {
                if(element > subArray[i]) {
                    subArray[i] = element;
                    break;
                }
            }
        }
    }











}
