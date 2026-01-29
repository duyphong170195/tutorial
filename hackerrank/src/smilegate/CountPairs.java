package smilegate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountPairs {

    public static int countPairs(List<Integer> taskCosts, int target) {
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
