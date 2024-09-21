package dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        solveProblem(n, 0, 0, n*2, "", result);

        return result;
    }

    public static void solveProblem(int n, int close, int open, int length, String parenthesis, List<String> results) {
        if(parenthesis.length() == length) {
            // TODO add to list
            results.add(parenthesis);
        }

        if(open < n) {
            solveProblem(n, close, open +1, length, parenthesis.concat("("), results);
        }

        if(close < open) {
            solveProblem(n, close +1, open, length, parenthesis.concat(")"), results);
        }
    }





    public static void main(String[] args) {
        System.out.println(
                generateParenthesis(3)
        );
    }
}
