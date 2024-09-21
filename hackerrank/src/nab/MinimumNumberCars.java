package nab;

import java.util.Arrays;
import java.util.Collections;

public class MinimumNumberCars {

    public static void main(String[] args) {
        int[] p ={1, 4, 1};
        int[] s ={1, 5, 1};

        System.out.println(solution(p, s));
    }

    public static int solution(int[] p, int[] s) {
        int sum = 0;
        for(int i = 0; i < p.length; i++) {
            sum += (s[i] - p[i]);
        }

        Arrays.sort(p);
        int count = 0;
        for(int i = 0; i < p.length; i++) {
            if(sum - p[i] >= 0) {
                sum = sum - p[i];
                count++;
            }
        }
        return count;
    }
}
