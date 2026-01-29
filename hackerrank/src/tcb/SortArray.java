package tcb;

import java.util.*;

public class SortArray {



    public static int sortArray(int N, int[] A, String S) {
        // Step 1: Check if the array is already sorted
        if (isSorted(A)) {
            return 0;
        }
        
        // Step 2: Check if there's any pair of elements with different magic bits
        boolean hasDifferentBits = false;
        for (int i = 0; i < N - 1; i++) {
            if (S.charAt(i) != S.charAt(i + 1)) {
                hasDifferentBits = true;
                break;
            }
        }
        
        // If no subarray can be formed with different magic bits, return -1
        if (!hasDifferentBits) {
            return -1;
        }
        
        // Step 3: Check if swapping a single subarray can sort the array
        if (S.contains("01") || S.contains("10")) {
            return 1; // If there's a pair with different bits, one operation is enough
        }
        
        return -1; // If nothing works, return -1
    }
    
    // Helper function to check if the array is already sorted
    private static boolean isSorted(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String a = "x";

        String b= new String("x");

        System.out.println(a.equals(b));
//        Scanner scanner = new Scanner(System.in);
//
//        // Read input values
//        int N = scanner.nextInt();
//        int[] A = new int[N];
//        for (int i = 0; i < N; i++) {
//            A[i] = scanner.nextInt();
//        }
//        String S = scanner.next();
//
//        // Call the function and print the result
//        int N = 5;
//        int A[] = {5, 1, 4, 2, 3};
//        String S = "01010";
//
//        int result = sortArray(N, A, S);
//        System.out.println(result);

//        scanner.close();

            ArrayList<String> list = new ArrayList<>();
            list.get(4);

    }
}
