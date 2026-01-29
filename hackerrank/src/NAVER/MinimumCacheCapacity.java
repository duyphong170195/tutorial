package NAVER;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MinimumCacheCapacity {

    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
//        data.addAll(List.of("item1", "item1", "item3", "item1", "item3"));
        data.addAll(List.of("item3", "item2", "item1", "item2", "item3"));
        Iterator<String> it = data.iterator();
        it.next();
        it.remove();
        it.next();
        it.remove();

        System.out.println(getMinimumSize(data, 2));

//        int arr[] = {1,1,1,1,0,0,0,0};
        int arr[] = {1,1,1,1,0,1,0,1};
//        System.out.println(minMoves(arr));
    }

    public static int getMinimumSize(List<String> requests, int k) {
        // Write your code here
        for(int cacheSize = 1; cacheSize < requests.size(); cacheSize++) {
            if(canAchieveHits(requests, cacheSize, k)) return cacheSize;
        }

        return -1;
    }


    private static boolean canAchieveHits(List<String> requests, int cacheSize, int k) {
        Set<String> cache= new LinkedHashSet<>();
        int hits = 0;

        for(String request : requests) {
            if(cache.contains(request)) {
                hits++;
                cache.remove(request);
            } else if(cache.size() == cacheSize) {
                Iterator<String> it = cache.iterator();
                it.next();
                it.remove();
            }
            cache.add(request);
            if(hits >= k) {
                return true;
            }
        }
        return hits > k;
    }

    public static int minMoves(List<Integer> arr) {
        int n = arr.size();

        int countOnes = 0;
        int swapsForOnesRight = 0;

        for(int i = 0; i<n; i ++) {
            if(arr.get(i) == 1) {
                countOnes++;
            } else {
                swapsForOnesRight += countOnes;
            }
        }

        int countZeros = 0;
        int swapsForZerosRight = 0;

        for(int i = 0; i<n; i++) {
            if(arr.get(i) ==0) {
                countZeros++;
            } else {
                swapsForZerosRight += countZeros;
            }
        }

        return Math.min(swapsForOnesRight, swapsForZerosRight);
    }
}
