package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToIntegerAtoi {

    public static void main(String[] args) {
// Fails at runtime!
//        Object[] objectArray = new Long[1];
//        objectArray[0] = "I don't fit in"; // Throws ArrayStoreException
//
//        List<Object> ol = new ArrayList<Long>(); // Incompatible types
//        ol.add("I don't fit in");
//        String a = "+123";
//        "a123";
//        "-a123";




    }

    public static int myAtoi(String s) {


        // handle first character is word

        // handle first character is number



        String decimalRegex = "[+-]?[0-9]+\\.?[0-9]*|\\.[0-9]+";

        String numberString = s.trim();

        String[] splitNumber = numberString.split("\\s+");

        String number = splitNumber[0];

        Pattern pattern = Pattern.compile(decimalRegex);

        Matcher matcher = pattern.matcher(number);

        int numberInt = 0;
        if (matcher.find()) {
            String numberFound = matcher.group();
            try {
                numberInt = Double.valueOf(numberFound).intValue();
            } catch (Exception e) {
                return 0;
            }
            return numberInt;
        }
        return 0;
    }
}


//        if (number.matches(decimalRegex)) {
//            int numberInt;
//            try {
//                numberInt = Double.valueOf(number).intValue();
//            } catch (Exception e) {
//                return 0;
//            }
//            return numberInt;
//        } else {
//            Pattern pattern = Pattern.compile(decimalRegex);
//
//            Matcher matcher = pattern.matcher(numberString);
//
//            int numberInt = 0;
//            if (matcher.find()) {
//                String numberFound = matcher.group();
//                try {
//                    numberInt = Double.valueOf(numberFound).intValue();
//                } catch (Exception e) {
//                    return 0;
//                }
//                return numberInt;
//            }
//        }