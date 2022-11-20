package leetcode.algorithms;

import java.util.TreeMap;

public class LongestPalindrome extends Thread{

    public static void main(String[] args) {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("i");
//        System.out.println(stringBuilder.toString());
//        System.out.println(longestPalindrome("abcdefbab"));
    }

//    public static String longestPalindrome(String s) {
//        if(s.length() == 1) {
//            return s;
//        }
//        if(s.length() == 2) {
//            return s.charAt(0) + "";
//        }
//        int length = s.length();
//        int left = length/2 - 1, right = length/2;
//        TreeMap<Integer, String> integerStringMap = new TreeMap<>();
//        while(left >= 0 && right <= length - 1) {
//            String result3 = dddd(s, left, right);
//            integerStringMap.put(result3.length(), result3);
//            int leftOfLeft = left, rightOfLeft = left + 1;
//            int leftOfRight = right, rightOfRight = right + 1;
//            String result1 = dddd(s, leftOfLeft, rightOfLeft);
//            integerStringMap.put(result1.length(), result1);
//            String result2 = dddd(s, leftOfRight, rightOfRight);
//            integerStringMap.put(result2.length(), result2);
//            left = left -1;
//            right = right + 1;
//        }
//        return integerStringMap.get(integerStringMap.lastKey());
//    }
//
//    public static String dddd(String s, int leftOfLeft, int rightOfLeft) {
//        if(leftOfLeft < 0 || rightOfLeft >= s.length()) {
//            return  "";
//        }
//        StringBuilder stringBuilderForLeft = new StringBuilder();
//        String characterLef = s.charAt(leftOfLeft) + "";
//        String characterRight = s.charAt(rightOfLeft) + "";
//        if(characterLef.equals(characterRight)) {
//            while (leftOfLeft >= 0 && rightOfLeft <= s.length() -1) {
//                String characterLef1 = s.charAt(leftOfLeft) + "";
//                String characterRight1 = s.charAt(rightOfLeft) + "";
//
//                if (characterLef1.equals(characterRight1)) {
//                    stringBuilderForLeft.insert(0, characterLef1);
//                    stringBuilderForLeft.append(characterRight1);
//                    leftOfLeft--;
//                    rightOfLeft++;
//                } else {
//                    break;
//                }
//            }
//        } else {
//            if(leftOfLeft > 0) {
//                stringBuilderForLeft.append(s.charAt(leftOfLeft) + "");
//                leftOfLeft = leftOfLeft - 1;
//                while (leftOfLeft >= 0 && rightOfLeft <= s.length() -1) {
//                    String characterLef1 = s.charAt(leftOfLeft) + "";
//                    String characterRight1 = s.charAt(rightOfLeft) + "";
//
//                    if (characterLef1.equals(characterRight1)) {
//                        stringBuilderForLeft.insert(0, characterLef1);
//                        stringBuilderForLeft.append(characterRight1);
//                        leftOfLeft--;
//                        rightOfLeft++;
//                    } else {
//                        break;
//                    }
//                }
//            }
//        }
//        return stringBuilderForLeft.toString();
//    }
//

//    public static String longestPalindrome2(String s) {
//        if(s.length() == 1) {
//            return s;
//        }
//        if( s.length() == 2) {
//            String s1 =s.charAt(0) + "";
//            String s2 =s.charAt(1) + "";
//            if(s1.equals(s2)) {
//                return s;
//            } else {
//                return s1;
//            }
//        }
//
//        TreeMap<Integer, String> integerStringMap = new TreeMap<>();
//        for(int i = 0; i< s.length() - 1; i++) {
//            for (int j = i + 1; j < s.length(); j++) {
//                String characterLef = s.charAt(i) + "";
//                String characterRight = s.charAt(j) + "";
//                StringBuilder stringBuilderForLeft = new StringBuilder();
//                StringBuilder stringBuilderForRight = new StringBuilder();
//                if(characterLef.equals(characterRight)) {
//                    stringBuilderForLeft.append(characterLef);
//                    stringBuilderForRight.insert(0, characterRight);
//                   int m = i + 1;
//                   int n = j - 1;
//                   while (m < n) {
//                       String characterLef2 = s.charAt(m) + "";
//                       String characterRight2 = s.charAt(n) + "";
//                       if(!characterLef2.equals(characterRight2)) {
//                           stringBuilderForLeft = new StringBuilder();
//                           stringBuilderForRight = new StringBuilder();
//                           break;
//                       }
//                       stringBuilderForLeft.append(characterLef2);
//                       stringBuilderForRight.insert(0, characterRight2);
//                       m++;
//                       n--;
//                   }
//                   if(m == n) {
//                       stringBuilderForLeft.append(s.charAt(m) + "");
//                   }
//                }
//                stringBuilderForLeft.append(stringBuilderForRight);
//                if(stringBuilderForLeft.length() > 0) {
//                    integerStringMap.put(stringBuilderForLeft.length(), stringBuilderForLeft.toString());
//                }
//            }
//        }
//        return integerStringMap.size() > 0 ? integerStringMap.get(integerStringMap.lastKey()) : s.charAt(0) + "";
//    }
//    public void run() {
//        this.longestPalindrome(a)
//    }

    public String longestPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        if(s.length() == 1) {
            return s;
        }
        if( s.length() == 2) {
            String s1 =s.charAt(0) + "";
            String s2 =s.charAt(1) + "";
            if(s1.equals(s2)) {
                return s;
            } else {
                return s1;
            }
        }

        TreeMap<Integer, String> integerStringMap = new TreeMap<>();
        for(int i = 0; i< s.length() - 1; i++) {
            for (int j = s.length() -1; j > i; j--) {
                char characterLef = stringBuilder.charAt(i);
                char characterRight = stringBuilder.charAt(j);
                StringBuilder stringBuilderForLeft = new StringBuilder();
                StringBuilder stringBuilderForRight = new StringBuilder();
                if(characterLef == characterRight) {
                    stringBuilderForLeft.append(characterLef);
                    stringBuilderForRight.insert(0, characterRight);
                    int m = i + 1;
                    int n = j - 1;
                    while (m < n) {
                        char characterLef2 = stringBuilder.charAt(m);
                        char characterRight2 = stringBuilder.charAt(n);
                        if(characterLef2 != characterRight2) {
                            stringBuilderForLeft = new StringBuilder();
                            stringBuilderForRight = new StringBuilder();
                            break;
                        }
                        stringBuilderForLeft.append(characterLef2);
                        stringBuilderForRight.insert(0, characterRight2);
                        m++;
                        n--;
                    }
                    if(m == n) {
                        stringBuilderForLeft.append(stringBuilder.charAt(m));
                    }
                }
                stringBuilderForLeft.append(stringBuilderForRight);
                if(stringBuilderForLeft.length() > 0) {
                    integerStringMap.put(stringBuilderForLeft.length(), stringBuilderForLeft.toString());
                }
            }
        }
        return integerStringMap.size() > 0 ? integerStringMap.get(integerStringMap.lastKey()) : stringBuilder.charAt(0) + "";
    }
}

