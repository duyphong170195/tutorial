package nab;

public class Task1_1 {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,71,2,3,1,2,3,4,5};
//        int[] a = {30,20,10};
//        int[] a = {2,2,2,2,1,2,-1,2,1,3};
        System.out.println(solution(a));
    }

    public static int solution(int[] a) {
        int startIndex = 0;
        int max = a[0];
        int count = 0;
        int maxCount = 0;
        int indexResult = 0;
        int markStartIndex = 0;
        boolean initialize = true;
        for(int i = 1; i < a.length; i++) {
            if(max < a[i]) {
                max = a[i];
                count++;
            } else {
                if(maxCount  < count) {
                    markStartIndex = startIndex;
                    maxCount = count;
                }
                startIndex = i;
                max = a[i];
                count = 0;
            }
        }

        if(maxCount < count) markStartIndex = startIndex;
        return  markStartIndex;


    }
}
