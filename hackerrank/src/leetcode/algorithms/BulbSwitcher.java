package leetcode.algorithms;

/**
 * https://leetcode.com/problems/bulb-switcher/discuss/77112/Share-my-o(1)-solution-with-explanation
 * https://leetcode.com/problems/bulb-switcher/discuss/1161362/Java-Code-with-Explanation
 */
public class BulbSwitcher {

    public static int bulbSwitch(int n) {
        if(n == 0 ) return 0;
        if(n == 1 ) return 1;
        int m = n+1;
        int bulbs[] = new int[m];
        for(int i = 1; i < m; i++) {
            bulbs[i] = 1;
        }
        int sum = n;
        for(int i = 2;  i < m; i++) {
            int j = 1;
            int k = j*i;
            for(; k<m; k++) {
//                int temp = bulbs[everyIndex] == 1 ? 0 : 1;
//                int everyIndex = i*j;
//                if(everyIndex < m) {
//                    int temp = bulbs[everyIndex] == 1 ? 0 : 1;
//                    bulbs[everyIndex] = temp;
//                } else {
//                    break;
//                }
            }
        }

        int count=0;
        for(int i = 1; i < m/2 ; i++){
            count += bulbs[i];
        }
        for(int i = m/2; i < m; i++) {
            count += bulbs[i] ;
        }
        return count;
    }

    public static void main(String[] args) {
        String message = "%s";
        String.format(message, "asssss");
        System.out.println(message);
//        bulbSwitch(4);
    }
}
