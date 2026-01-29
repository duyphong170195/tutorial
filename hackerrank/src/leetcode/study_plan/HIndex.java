package leetcode.study_plan;

import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) {
//        int[] citations = {3,0,6,1,5}; // 0,1,3,5,6
        int[] citations = {1,3,1};
//        int[] citations = {5,5,5,5,5};
//        int[] citations = {1,1};

        // 0,1,3,5,6
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int maxValue = 0;
        for(int i = citations.length -1; i>=0; i--) {
            int citationValue = citations[i];
            int j = citations.length -1;
            int count = 0;
            while (j >= i) {
                if(count == citationValue) {
                    break;
                } else if(citations[j] >= citationValue) {
                    count++;
                }
                else {
                    break;
                }
                j--;
            }
            maxValue = Math.max(count,maxValue);
        }

        return maxValue;
    }

    public static int hIndex2(int[] citations) {
        Arrays.sort(citations); // Sort ascending
        int n = citations.length;
        int h = 0;

        for (int i = 0; i < n; i++) {
            int papersWithAtLeast = n - i; // papers from i to end
            if (citations[i] >= papersWithAtLeast) {
                h = papersWithAtLeast;
                break;
            }
        }
        return h;
    }
}
