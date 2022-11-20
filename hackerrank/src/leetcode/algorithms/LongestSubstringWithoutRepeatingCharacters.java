package leetcode.algorithms;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring2("abba"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0 ){
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }
        Set<String>  set = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i = 0 ; i < s.length()-1; i++) {
            set.add(s.charAt(i) + "");
            for (int j = i + 1; j < s.length(); j++) {
                if(set.contains(s.charAt(j) + "")) {
                   treeSet.add(set.size());
                   set = new HashSet<>();
                   break;
                } else {
                    set.add(s.charAt(j) + "");
                }
            }
            treeSet.add(set.size());
            if(treeSet.last() >= s.length() - i) {
                break;
            }
        }
        return treeSet.last();
    }

    public static int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() == 0 ){
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }

        int startIndex = 0;
        int result = 0;
        int endIndex = 0;
        Map<String, Integer> subString = new HashMap<>();
        for(; endIndex < s.length(); endIndex ++) {
            String character = s.charAt(endIndex) + "";
            if(subString.containsKey(character)) {
                int newResult = endIndex - startIndex;
                if(result < newResult) {
                    result = newResult;
                }
                // temp index
                int j = startIndex;
                startIndex = subString.get(character) + 1;
                // remove all character before new start index
                for(; j < startIndex; j++) {
                    subString.remove(s.charAt(j) + "", j);
                }
            }

            subString.put(character, endIndex);
        }
        int newResult = endIndex - startIndex;
        if(result < newResult) {
            result = newResult;
        }
        return result;
    }
}
//        for(int i = 0; i < s.length(); i++) {
//            if(set.contains(s.charAt(i) + "")) {
//                treeSet.add(set.size());
//                if(set.size() < s.length()  - i) {
//
//                    set = new HashSet<>();
//                    set.add(s.charAt(i) + "");
//                } else {
//                    break;
//                }
//            } else {
//                set.add(s.charAt(i) + "");
//            }
//        }
//        treeSet.add(set.size());