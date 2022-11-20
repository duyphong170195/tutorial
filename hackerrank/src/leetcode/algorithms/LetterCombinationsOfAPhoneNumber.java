package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        List<String> list = letterCombinations3("2345");
        list.forEach(a -> System.out.println(a));

    }

    public static List<String> letterCombinations(String digits) {
        if(digits.equals("")) {
            return Collections.emptyList();
        }

        Map<Integer, List<Character>> intToString = new HashMap<>();
        intToString.put(2, new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        intToString.put(2, new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        intToString.put(2, new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        intToString.put(2, new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        intToString.put(2, new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        intToString.put(2, new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        intToString.put(2, new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        intToString.put(2, new ArrayList<>(Arrays.asList('w', 'x', 'y','z')));
//        intToString.put(3, "abc");
//        intToString.put(3, "def");
//        intToString.put(4, "ghi");
//        intToString.put(5, "jkl");
//        intToString.put(6, "mno");
//        intToString.put(7, "pqrs");
//        intToString.put(8, "tuv");
//        intToString.put(9, "wxyz");

        StringBuilder permutation  = new StringBuilder();
        for(int i = 0; i < digits.length(); i++) {
            permutation.append(intToString.get(Integer.valueOf(digits.charAt(i) + "")));
        }

        String stringPermutation = permutation.toString();
        List<String> permutations = new ArrayList<>();
        permutations.add(permutation.toString());

        for(int i = 0; i < permutation.length(); i++) {
            for(int j = i + 1; j< permutation.length() -1; j++) {
                StringBuilder pe = new StringBuilder(permutation);
                char a = pe.charAt(i);
                char b = pe.charAt(j);
                pe.setCharAt(j, a);
                pe.setCharAt(i, b);
                permutations.add(pe.toString());
            }
        }
        return permutations;
    }

    public static List<String> letterCombinations2(String digits) {
        if(digits.length() == 0) {
            return Collections.emptyList();
        }


        Map<Character, List<String>> intToString = new HashMap<>();
        intToString.put('2', Arrays.asList("a", "b", "c"));
        intToString.put('3', Arrays.asList("d", "e", "f"));
        intToString.put('4', Arrays.asList("g", "h", "i"));
        intToString.put('5', Arrays.asList("j", "k", "l"));
        intToString.put('6', Arrays.asList("m", "n", "o"));
        intToString.put('7', Arrays.asList("p", "q", "r", "s"));
        intToString.put('8', Arrays.asList("t", "u", "v"));
        intToString.put('9', Arrays.asList("w", "x", "y", "z"));

        if(digits.length() == 1) {
            return intToString.get(digits.charAt(0));
        }
        Deque<String> queue = new ArrayDeque();
        List<String> stringList = intToString.get(digits.charAt(0));
        for(int i =0; i< stringList.size(); i++) {
            queue.addLast(stringList.get(i));
        }

        int n =1;
        while (n < digits.length()) {
            List<String> newWords = intToString.get(digits.charAt(n));
            String popped = queue.pop();
            for(String c : newWords) {
                StringBuilder newStr = new StringBuilder(popped + c);
                queue.addLast(newStr.toString());
            }

            if(queue.getFirst().length() > n) {
                n+=1;
            }
        }
        return queue.stream().collect(Collectors.toList());
    }

    public static List<String> letterCombinations3(String digits) {
        /*
        * Idea: 1. nhét chuỗi của digit đầu tiên(digits[0]) vào một cái queue
        * 2. lấy phần tử đầu của queue (popped = queue.pop)
        * 3. Sau đó lấy từng kỹ tự của chuỗi của digit thứ 2 (digits[1]) rồi  append vào cái popped
        * 4.
        * */



        if(digits.length() == 0) {
            return Collections.emptyList();
        }

        Map<Character, List<String>> intToString = new HashMap<>();
        intToString.put('2', Arrays.asList("a", "b", "c"));
        intToString.put('3', Arrays.asList("d", "e", "f"));
        intToString.put('4', Arrays.asList("g", "h", "i"));
        intToString.put('5', Arrays.asList("j", "k", "l"));
        intToString.put('6', Arrays.asList("m", "n", "o"));
        intToString.put('7', Arrays.asList("p", "q", "r", "s"));
        intToString.put('8', Arrays.asList("t", "u", "v"));
        intToString.put('9', Arrays.asList("w", "x", "y", "z"));

        Deque<String> queue = new ArrayDeque();
        List<String> stringOfFirstDigit = intToString.get(digits.charAt(0));
        for(int i = 0; i< stringOfFirstDigit.size(); i++) {
            queue.addLast(stringOfFirstDigit.get(i));
        }
        int currentLevelOfTree = 1;

        while (currentLevelOfTree < digits.length()) {
            // 3
            List<String> nextStringOfDigit = intToString.get(digits.charAt(currentLevelOfTree));
            // 2
            String queued = queue.pop();
            for(String character : nextStringOfDigit) {
                String a = queued + character;
                queue.addLast(a);
            }
            if(queue.getFirst().length() != currentLevelOfTree) {
                currentLevelOfTree ++;
            }
        }
        return queue.stream().collect(Collectors.toList());
    }

    /*
     * Idea: 1. nhét chuỗi của digit đầu tiên(digits[0]) vào một cái queue
     * 2. lấy phần tử đầu của queue (popped = queue.pop)
     * 3. Sau đó lấy từng kỹ tự của chuỗi của digit thứ 2 (digits[1]) rồi  append vào cái popped
     * 4. kiểm tra xem đã duyệt xong chiều rộng của level chưa. Nếu chưa thì duyệt tiếp, Nếu rồi thì tăng level
     * */
}
