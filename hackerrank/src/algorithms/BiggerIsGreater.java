package algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public static String biggerIsGreater(String w) {
        // Write your code here

        char[] charArray =  w.toCharArray();

        int pivotIndex= charArray.length - 1;

        while(pivotIndex > 0 && charArray[pivotIndex -1] >= charArray[pivotIndex]) {
            pivotIndex--;
        }

        if(pivotIndex == 0) {
            return "no answer";
        }

        int j = charArray.length - 1;


        while(charArray[pivotIndex - 1] >= charArray[j]) {
            j--;
        }

        char temp = charArray[pivotIndex - 1];
        charArray[pivotIndex - 1]   = charArray[j];
        charArray[j] = temp;

        j = charArray.length -1;
        while(pivotIndex < j) {
            char temp1 = charArray[pivotIndex];
            charArray[pivotIndex] = charArray[j];
            charArray[j] = temp1;
            pivotIndex ++;
            j--;
        }

        return String.valueOf(charArray);
    }

    static String catAndMouse(int x, int y, int z) {
        // which cat will reach the mouse first,
        // assuming the mouse does not move and the cats travel at equal speed.
        if(Math.abs(z-y) < Math.abs(z-x)) {
            System.out.println("Cat B");
            return "Cat B";
        } else if (Math.abs(z-y) > Math.abs(z-x)) {
            return "Cat A";
        } else {
            return "Mouse C";
        }
    }

    public static String dayOfProgrammer(int year) {
        // Write your code here
        int dayNumberOfLeapYear = checkLeapYear(year) ? 29 : 28;
        int day = 256 - (31 + dayNumberOfLeapYear + 31 + 30 + 31 + 30 + 31 + 31);
        return day + ".09" + "." + year;
    }

    static boolean checkLeapYear(int year)
    {
        if( year >= 1700 && year <= 1917 ) {
            if (year % 4 == 0) {
                return true;
            }
        }
        if( year > 1917 && year <= 2700) {
            if(year % 400 == 0) {
                return true;
            }

            if (year % 4 == 0 && year % 100 != 0)
                return true;
        }
        return false;
    }

    static boolean checkLeapYear2(int year) {

        if( year >= 1700 && year <= 1917 ) {
            if (year % 4 == 0) {
                return true;
            }
        }
         if( year > 1917 && year <= 2700) {
             if((year % 400 == 0 || year % 4 == 0) && year % 100 != 0) {
                 return true;
             }
         }

       return false;
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        Map<Integer, Integer> pairOfSocks = new HashMap<>();

        for(int i = 0; i < n; i++ ) {
            if(pairOfSocks.containsKey(ar.get(i))){
                Integer count = pairOfSocks.get(ar.get(i)) + 1;
                pairOfSocks.put(ar.get(i), count);
            }else {
                pairOfSocks.put(ar.get(i), 1);
            }
        }
        int sumPair = 0;
        for (Map.Entry<Integer,Integer> entry : pairOfSocks.entrySet()) {
            sumPair += entry.getValue() / 2;
        }
        return sumPair;
    }


    public static void main(String[] args) {
//        System.out.println(checkLeapYear(2700));
//        System.out.println( dayOfProgrammer(1918));
//        System.out.println(BiggerIsGreater.biggerIsGreater("dkhc"));
        String a = null;
        System.out.println(a.contains("Amount is not same with voucher amount"));
    }
}
