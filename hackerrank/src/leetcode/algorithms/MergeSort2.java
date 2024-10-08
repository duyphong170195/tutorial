package leetcode.algorithms;

public class MergeSort2 {

    // Merge two subarrays L and M into arr
    void merge(int arr[], int left, int mid, int right) {

        // Sizes of the two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] L = new int[n1];
        int[] M = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            M[j] = arr[mid + 1 + j];

        // Merge the temporary arrays back into arr[left..right]

        // Initial indices of the subarrays
        int i = 0, j = 0;

        // Initial index of merged array
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of L[]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy any remaining elements of M[]
        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }
    }

    // Divide the array into two subarrays, sort them and merge them
    void mergeSort(int arr[], int left, int right) {
        if (left < right) {

            // Find the middle point
            int mid = (left + right) / 2;

            // Recursively sort the two halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Print the array
    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method to run the MergeSort algorithm
    public static void main(String[] args) {
        int[] arr = {12, 11, 13,9,8,5, 6, 7};
        MergeSort2 ms = new MergeSort2();

        System.out.println("Given Array:");
        ms.printArray(arr);

        ms.mergeSort333(arr, 0, arr.length - 1);

        System.out.println("Sorted Array:");
        ms.printArray(arr);
    }

    void mergeSort333(int arr[], int left, int right) {
        if(left < right) {
            int mid = (right + left) /2;


            mergeSort333(arr, left, mid);
            mergeSort333(arr, mid + 1, right);

            //
            merge333(arr, left, mid, right);
        }
    }

    void merge333(int arr[], int left, int mid, int right) {
        // size of two array
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[] n = new int[leftSize];
        int[] m = new int[rightSize];


        for(int i = 0; i < leftSize; i++) {
            n[i] = arr[left + i];
        }

        for(int j = 0; j < rightSize; j++) {
            m[j] = arr[mid + 1 + j];
        }

        int k = left;
        int i = 0,j = 0;
        while(i < leftSize && j < rightSize) {
            if(n[i] <= m[j]) {
                arr[k] = n[i];
                i++;
            } else {
                arr[k] = m[j];
                j++;
            }
            k++;
        }

        while(i < leftSize) {
            arr[k]= n[i];
            i++;
            k++;
        }

        while(j < rightSize) {
            arr[k]= m[j];
            j++;
            k++;
        }
    }
}
