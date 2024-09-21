package leetcode.algorithms;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("dvdf"));
//        System.out.println(lengthOfLongestSubstring2("abba"));
//        System.out.println(String.valueOf(1) + String.valueOf(2));
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(5);
        a.add(-8);
        a.add(-6);
        a.add(-7);
        System.out.println(gainMaxValue(a, 3));
    }

    public static int gainMaxValue(List<Integer> security_val, int k) {
        // Write your code here
        int n = security_val.size();
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MIN_VALUE);

        int maxSum = Integer.MIN_VALUE;

        for(int i = n-1; i>=0; i--) {
            if(i+k >=n) {
                dp[i] = security_val.get(i);
            } else {
                dp[i] = security_val.get(i) + dp[i+k];
            }

            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
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

    public static int countPairs(List<Integer> taskCosts, int target) {
        // Write your code here
//        Collections.sort(taskCosts);
//        Set<String> avoidDuplication = new HashSet<>();
//        int count = 0;
//        for(int i = 0; i< taskCosts.size()-1; i++) {
//            for(int j = 0; j<taskCosts.size(); j++) {
//                if(taskCosts.get(j) - taskCosts.get(i) == target
//                        && !avoidDuplication.contains(String.valueOf(taskCosts.get(i)) + String.valueOf(taskCosts.get(j)))) {
//                    count++;
//                    avoidDuplication.add(String.valueOf(taskCosts.get(i) + taskCosts.get(j)));
//                    break;
//                }
//            }
//        }

        Set<Integer> results = new HashSet<>();
        int count = 0;
        for(int i = 0; i< taskCosts.size(); i++) {
            if(results.contains(taskCosts.get(i) + target)) {
                count++;
            }
            if(results.contains(taskCosts.get(i) - target)) {
                count++;
            }
            results.add(taskCosts.get(i));
        }
        return count;
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