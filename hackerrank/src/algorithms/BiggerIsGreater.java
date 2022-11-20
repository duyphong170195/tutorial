package algorithms;

import java.util.Arrays;

public class BiggerIsGreater {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

//    Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:

//    It must be greater than the original word
//    It must be the smallest word that meets the first condition
    // có thể áp dụng merge sort và binary search tree để sort và tìm kiếm nhanh hơn
    public static String biggerIsGreater(String w) {

        char[] charArray = w.toCharArray();

        int indexPivot = getPivot(charArray);

        if( indexPivot == -1) {
            return "no answer";
        }

        if(checkDESCSortedArray(charArray) == 1) {
            return "no answer";
        }

        char[] sortedSubArray = Arrays.copyOfRange(charArray, indexPivot + 1, charArray.length);

        Arrays.sort(sortedSubArray);
        int checkPossible = 0;
        for(int i = 0 ; i <sortedSubArray.length; i++) {
            if(charArray[indexPivot] < sortedSubArray[i]) {
                char temp = charArray[indexPivot];
                charArray[indexPivot] = sortedSubArray[i];
                sortedSubArray[i] = temp;
                break;
            } else {
                checkPossible ++;
            }
        }

        Arrays.sort(sortedSubArray);
        int indexOfSubArray = 0;
        for(int i = indexPivot + 1; i < charArray.length; i++) {
            charArray[i] = sortedSubArray[indexOfSubArray];
            indexOfSubArray++;
        }

        return String.valueOf(charArray);
    }

    static int checkDESCSortedArray(char[] charArray) {
        for(int i = 0; i< charArray.length -1; i++) {
            if(charArray[i] < charArray[i+1]) {
                return 0;
            }
        }

        return 1;
    }

    public static int getPivot(char[] charArray) {
        int indexPivot = 0;
        int checkSorted = 0;
        if(charArray[0] > charArray[1]) {
            indexPivot = 0;
        } else {
            for(int i = 0; i< charArray.length - 1; i++) {
                if(charArray[i] > charArray[i+1]) {
                    indexPivot = i-1;
                    break;
                }
                checkSorted++;
            }
        }
        if (checkSorted == charArray.length) {
            return -1;
        }
        return indexPivot;
    }

    static boolean nextPermutation(char[] array) {
        // Find longest non-increasing suffix
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i])
            i--;
        // Now i is the head index of the suffix

        // Are we at the last permutation already?
        if (i <= 0)
            return false;

        // Let array[i - 1] be the pivot
        // Find rightmost element greater than the pivot
        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;
        // Now the value array[j] will become the new pivot
        // Assertion: j >= i

        // Swap the pivot with j
        char temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        // Reverse the suffix
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        System.out.println(array);
        // Successfully computed the next permutation
        return true;
    }


    public static void main(String[] args) {
//        System.out.println(biggerIsGreater("abcd"));
        nextPermutation("fedcbabcd".toCharArray());
    }
}
