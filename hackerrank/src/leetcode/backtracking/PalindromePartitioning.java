package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {

        String a = "ab";

        System.out.println(a.substring(0,1));
    }


//    public List<List<String>> partition(String s) {
//
//        List<List<String>> result = new ArrayList<>();
//        int length = s.length();
//        for(int i = 0; i < length; i++)  {
//            List<String> partition = new ArrayList<>();
//            partition.add(s.charAt(i) + "");
//            result.add(partition);
//            int left = i - 1;
//            int right = i + 1;
//
//
//            while(left > 0 && right < length && s.charAt(left) == s.charAt(right)) {
//
//
//            }
//        }
//    }

    public static void backtrack(String s, List<String> current, List<List<String>> result, int start) {


        for(int i = start; i < s.length(); i++)  {
            String sub = s.substring(start, i);
            // TODO verify sub is Palindrome
            current.add(s.charAt(i) + "");

            backtrack(s, current, result, i + 1);
        }
    }
}
