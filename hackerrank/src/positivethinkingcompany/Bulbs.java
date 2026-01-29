package positivethinkingcompany;

import java.util.List;

public class Bulbs {

    public static long bulbs(List<Long> bulbs) {
        int count = 0;
        for(int i = 0; i< bulbs.size(); i++) {
            if (bulbs.get(i) - i  == 1 || bulbs.get(i) - i  == 0) {
                count++;
                System.out.println(i);
            }
        }
        return count;
    }
}
