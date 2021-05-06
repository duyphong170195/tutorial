package algorithms;

import java.util.*;

public class QueenAttackII {


    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        int sum = 0;

        Set<String> attackedPositions = new HashSet<>();
        for(int i = 0; i < obstacles.size(); i++) {
            List<Integer> obstacle = obstacles.get(i);
            attackedPositions.add(obstacle.get(0) + " " + obstacle.get(1));
        }
        // duyet len
        for(int i = r_q - 1; i > 0; i--) {
            if(attackedPositions.contains(i + " " + c_q)) {
                break;
            }
            sum++;
        }

        // duyet xuong
        for(int i = r_q + 1; i <= n; i++) {
            if(attackedPositions.contains(i + " " + c_q)) {
                break;
            }
            sum++;
        }

        // duyet trai
        for(int i = c_q - 1; i > 0; i--) {
            if(attackedPositions.contains(r_q + " " + i)) {
                break;
            }
            sum++;
        }

        // duyet phai
        for(int i = c_q + 1; i <= n; i++) {
            if(attackedPositions.contains(r_q + " " + i)) {
                break;
            }
            sum++;
        }
        // duyet cheo ve ben phai
        for(int i = r_q + 1, j = c_q + 1; i <= n && j <= n; i++, j++) {
            if(attackedPositions.contains(i + " " + j)) {
                break;
            }
            sum++;
        }

        for(int i = r_q - 1, j = c_q + 1; i > 0 && j <= n; i--, j++) {
            if(attackedPositions.contains(i + " " + j)) {
                break;
            }
            sum++;
        }
        // duyet treo ve ben trai
        for(int i = r_q - 1, j = c_q - 1; i > 0 && j > 0; i--, j--) {
            if(attackedPositions.contains(i + " " + j)) {
                break;
            }
            sum++;
        }

        for(int i = r_q + 1, j = c_q - 1; i <= n && j > 0; i++, j--) {
            if(attackedPositions.contains(i + " " + j)) {
                break;
            }
            sum++;
        }
        return sum;
    }
    public static void main(String[] args) {
    }
}
