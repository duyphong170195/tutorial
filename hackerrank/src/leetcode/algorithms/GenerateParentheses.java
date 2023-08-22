package leetcode.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    public static void main(String[] args) {
        generateParenthesis6(3);
        System.out.println(linkedList);
    }

    static LinkedList<String> linkedList = new LinkedList<>();

    public static void generateParenthesis6(int n) {
        generate(0, 0, n, n*2, "");
        System.out.println();
    }

    static void generate(int open, int close, int n , int size, String stringBuilder) {

        // stop back tracking
        if( stringBuilder.length() == size) {
            linkedList.add(stringBuilder);
        }
        //
        if(open < n) {
//            stringBuilder = ;
//            open++;
            generate(open + 1, close, n, size, stringBuilder + "(");
        }

        if(close < open) {
//            stringBuilder = stringBuilder.concat(")");
//            close ++;
            generate(open, close + 1, n, size, stringBuilder + ")");
        }
    }


























    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        rearrange(n, list, new StringBuilder(), 0, 0);
        return list;
    }
    // https://leetcode.com/problems/generate-parentheses/discuss/2616453/Java-Recursion-Solution
    public static void rearrange(int n, List<String> list, StringBuilder sb, int open, int close) {

        if (sb.length() == 2 * n) {
            list.add(sb.toString());
        }

        if (open < n) {
            StringBuilder x = new StringBuilder();
            x.append(sb);
            x.append("(");
            rearrange(n, list, x, open + 1, close);
        }

        if (open > close) {
            StringBuilder y =  new StringBuilder();
            y.append(sb);
            y.append(")");
            rearrange(n, list, y, open, close + 1);
        }
    }

    // https://leetcode.com/problems/generate-parentheses/discuss/2612003/O(n)-Java-Solution

    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList();
        StringBuilder currStr = new StringBuilder();
        int leftPars = n;
        int rightPars = n;
        dfs(leftPars, rightPars, currStr, result);
        return result;
        // T.C: O(n)
        // S.C: O(n)
    }

    public void dfs(int leftPars, int rightPars, StringBuilder currStr, List<String> result) {
        if (leftPars == 0 && rightPars == 0) {
            result.add(currStr.toString());
            return;
        }

            currStr.append("(");
            dfs(leftPars - 1, rightPars, currStr, result);
            if (leftPars > 0) {
            currStr.deleteCharAt(currStr.length() - 1);
        }

        if (rightPars > 0 && rightPars > leftPars) {
            currStr.append(")");
            dfs(leftPars, rightPars - 1, currStr, result);
            currStr.deleteCharAt(currStr.length() - 1);
        }
    }

//    public int solution(int[] a, int k) {
////        Arrays.sort(a);
////        int i = a.length -1;
//
//        for(int i = 0; i <= a.length - k; i++) {
//            int m = k;
//
//        }
//    }
}
