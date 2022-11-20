package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ZigzagConversion5 {

    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder[] strings = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            strings[i] = new StringBuilder();
        }
        if(numRows == 2) {
            for (int i = 0; i < s.length(); i++) {
                strings[i%2].append(s.charAt(i));
            }
        } else {
            int i = 0;
            while (true) {
                for(int j = 0; j < numRows; j ++) {
                    if(i == s.length()) break;
                    strings[j].append(s.charAt(i));
                    i++;
                }
                if(i == s.length()) break;
                for(int j = (numRows -2); j > 0; j--) {
                    if(i == s.length()) break;
                    strings[j].append(s.charAt(i));
                    i++;
                }
                if(i == s.length()) break;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            result.append(strings[j]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
//        int row = 4;
//        String a = "PAYPALISHIRING";
//        if(row == 1) return;
//        List<String> list = new ArrayList<>();
//        TreeMap<Integer, StringBuilder> treeMap = new TreeMap<>();
//        StringBuilder[] strings = new StringBuilder[row];
//        for (int i = 0; i < row; i++) {
//            strings[i] = new StringBuilder();
//        }
//        int i = 0;
//
//
//        while (true) {
//            for(int j = 0; j < row; j ++) {
//                if(i == a.length()) break;
//                strings[j].append(a.charAt(i));
//                i++;
//            }
//            if(i == a.length()) break;
//            for(int j = row - (row -2); j > 0; j--) {
//                if(i == a.length()) break;
//                strings[j].append(a.charAt(i));
//                i++;
//            }
//            if(i == a.length()) break;
//        }
//
//        StringBuilder result = new StringBuilder();
//        for (int j = 0; j < row; j++) {
//            result.append(strings[j]);
//        }
//        System.out.println(result.toString());
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
