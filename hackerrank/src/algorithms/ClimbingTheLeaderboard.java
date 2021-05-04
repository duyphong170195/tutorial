package algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class ClimbingTheLeaderboard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        // Write your code here
//        List<Integer> distinctRanked = ranked.stream().distinct().collect(Collectors.toList());
            // Write your code here
        List<Integer> positions = new ArrayList<>();

        LinkedHashSet<Integer> distinctRanked = new LinkedHashSet<>(ranked);

        ArrayList<Integer> listWithoutDuplicates = new ArrayList<>(distinctRanked);

        for(int i = 0; i< player.size(); i++) {
            findPosition(listWithoutDuplicates, player.get(i), 0, listWithoutDuplicates.size()-1, positions);
        }
        List<Integer> results = positions.stream().map(integer -> integer + 1).collect(Collectors.toList());
        return results;
    }

    public static void findPosition(List<Integer> ranked, int player, int l, int r, List<Integer> positions) {
        if(l>r) {
            return;
        }

        if(l==r) {
            if(ranked.get(l) < player) {
                positions.add(l);
                return;
            } else if(ranked.get(l) == player) {
                positions.add(l);
                return;
            } else {
                positions.add(l + 1);
                return;
            }
        }

        int m = l + (r-l)/2;
        if(ranked.get(m) <= player) {
            findPosition(ranked, player, l, m, positions);
        } else {
            findPosition(ranked, player, m+1, r, positions);
        }
    }

    public static void main(String[] args) {
        List<Integer> ranked1 = Arrays.asList(100, 90, 90, 80);
        List<Integer> ranked2 = Arrays.asList(100, 100, 50, 40, 40, 20, 10);


        List<Integer> players1 = Arrays.asList(70, 80, 105);
        List<Integer> players2 = Arrays.asList(5, 25, 50, 120);
        climbingLeaderboard(ranked2, players2);

    }
}
