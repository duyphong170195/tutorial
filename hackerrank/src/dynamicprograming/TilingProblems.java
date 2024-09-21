package dynamicprograming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TilingProblems {

    public static void main(String[] args) {

        List<Integer> tiles = List.of(1,1,2,4);
        int boardOfLength = 4;

        System.out.println(
                solve(0, tiles, boardOfLength)
        );
        Map<Integer, Integer> functionToResult = new HashMap<>();
        System.out.println(
                solve2(boardOfLength, functionToResult)
        );

    }

    public static int solve(int currentTile, List<Integer> tiles, int boardOfLength) {

        if(currentTile > boardOfLength) {
            return 0;
        }

        if(currentTile == boardOfLength) {
            return 1;
        }

        int sum = 0;
        for(int i = 0; i< tiles.size(); i++) {

            sum += solve(currentTile + tiles.get(i), tiles, boardOfLength);
        }

        return sum;
    }


    public static int solve2(int boardOfLength, Map<Integer, Integer> functionToResult) {
        if(boardOfLength == 0) {
            return 1;
        }

        if(boardOfLength < 0) {
            return 0;
        }
        int sum = 0;
        return sum += solve2(boardOfLength -1, functionToResult) + solve2(boardOfLength -2, functionToResult);
    }
}
