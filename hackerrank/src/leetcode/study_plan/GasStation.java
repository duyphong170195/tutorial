package leetcode.study_plan;

public class GasStation {


    public static void main(String[] args) {
        int[] gas2  = {3, 1, 1};
        int[] cost2 = {1, 2, 2};
        System.out.println(GasStation.canCompleteCircuit(gas2, cost2)); // Output: -1

    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int totalTank = 0;
        int start = 0;
        int currentTank = 0;

        for(int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];

            totalTank += diff;
            currentTank += diff;

            if(currentTank <0) {
                start = i + 1;
                currentTank = 0;
            }
        }

        return totalTank >= 0 ? start : -1;
    }
}
