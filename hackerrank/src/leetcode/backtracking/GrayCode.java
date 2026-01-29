package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public static void main(String[] args) {
        int result = (int)(Math.pow(2,4) -1);

        System.out.println(grayCode(2));
    }

    public static List<String> grayCode(int n) {


        List<String> resultForPrefixZero = new ArrayList<>();
        // backtrack for 0
        StringBuilder sbForZero = new StringBuilder("0");
        backtrack(resultForPrefixZero, sbForZero, n);
        // backtrack for 1
        List<String> resultForPrefixOne = new ArrayList<>();
        StringBuilder sbForOne = new StringBuilder("1");
        backtrack(resultForPrefixOne, sbForOne, n);

        List<String> finalResult = new ArrayList<>();
        for(int i =0; i< resultForPrefixZero.size(); i++) {
            finalResult.add(resultForPrefixZero.get(i));
            finalResult.add(resultForPrefixOne.get(i));
        }

        return finalResult;

    }

    public static void backtrack(List<String> result, StringBuilder sb, int numberOfBits) {
        if(sb.length() == numberOfBits) {
            result.add(sb.toString());
            return;
        }
        for(int i = 0; i< 2; i++) {
            sb.append(i);
            backtrack(result, sb, numberOfBits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // https://chatgpt.com/c/6721fad8-0ec8-8013-b1d9-5e5ab64238dc
    public List<Integer> grayCode2(int n) {
        List<Integer> result = new ArrayList<>();
        int sequenceLength = 1 << n; // 2^n

        for (int i = 0; i < sequenceLength; i++) {
            // Generate the i-th Gray code by XORing i with i >> 1
            int grayCode = i ^ (i >> 1);
            result.add(grayCode);
        }

        return result;
    }
}
