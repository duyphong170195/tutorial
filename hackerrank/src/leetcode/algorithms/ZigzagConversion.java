package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ZigzagConversion {

    public static void main(String[] args) {
        String a = "PAYPALISHIRING";
        List<String> list = new ArrayList<>();
        TreeMap<Integer, StringBuilder> treeMap = new TreeMap<>();
        int row = 3;
        StringBuilder[] strings = new StringBuilder[row];
        for (int i = 0; i < row; i++) {
            strings[i] = new StringBuilder();
        }
        int i = 0;
        while (true) {
            for(int j = 0; j < row; j ++) {
                if(i == a.length()) break;
                strings[j].append(a.charAt(i));
                i++;
            }
            if(i == a.length() - 1) break;
            for(int j = row - (row -1); j > 0; j--) {
                if(i == a.length()) break;
                strings[j].append(a.charAt(i));
                i++;
            }
            if(i == a.length()) break;
        }

        StringBuilder result = new StringBuilder();
        for (int j = 0; i < row; i++) {
            result.append(strings[i]);
        }
        System.out.println(result.toString());


    }
}
