package nab;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MinimumNumberOfSubStrings {

    public static void main(String[] args) {
//        String s = "abacdec";
//        String s = "world";
//        String s = "dddd";
        String s = "cycle";
        System.out.println(solution(s));
    }


    public static int solution(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i<s.length(); i++) {
            Character character = s.charAt(i);
            if(!set.contains(character)) {
                set.add(character);
            } else {
                count++;
                set = new HashSet<>();
                set.add(character);
            }

        }
        count++;

        return count;
    }
}
