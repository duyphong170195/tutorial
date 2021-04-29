package datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SparseArrays {

    static int[] matchingStrings(String[] strings, String[] queries) {
        Map<String, Integer> queriesMap = new HashMap<>();

        for(int i = 0; i < queries.length; i++) {
            queriesMap.put(queries[i], 0);
        }

        for(int i = 0; i < strings.length; i++) {
            if(queriesMap.containsKey(strings[i])) {
                queriesMap.put(strings[i], queriesMap.get(strings[i]) + 1);
            }
        }

        int results[] = new int[queries.length];
        for(int i =0; i< queries.length;i++) {
            results[i] = queriesMap.get(queries[i]);
        }
        return results;
    }

    public static void main(String[] args) {
        String strings[] = new String[]{"def", "de", "fgh"};
        String queries[] = new String[]{"de", "lmn", "fgh"};

        int results[] = matchingStrings(strings, queries);

        System.out.println(results);
    }
}
