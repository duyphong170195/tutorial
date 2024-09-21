package williamfiset;

import java.util.List;

public class TilingProblems2 {

    public static void main(String[] args) {
        System.out.println(solve(7));
    }

    static Integer solve(int n) {
        if(n == 0) return 1;
        if(n < 0) return 0;

        int sum = 0;
        sum += 2*solve(n-1) + solve(n-2) + solve(n-4);
        return sum;
    }
}
