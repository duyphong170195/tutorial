package leetcode.algorithms;

public class WhereWillTheBallFall {

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1,1},
                       {-1,-1,-1,-1,-1,-1},
                      {1,1,1,1,1,1},
                      {-1,-1,-1,-1,-1,-1}};
        int[] result = findBall(grid);
        System.out.println();
//        int[][] grid2 = {{1, 1, 1, -1, -1},
//                {1, 1, 1, -1, -1},
//                {-1, -1, -1, 1, 1},
//                {1, 1, 1, 1, -1},
//                {-1,-1,-1,-1,-1}};
////
//        int[] result2 = findBall(grid2);
//        int[][] grid3 = {{-1}};
//        findBall(grid3);

    }

    public static int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];
        for(int i = 0; i < grid[0].length ; i++) {
            int columnFirst = i;
            int count = 0;

            for(int j = 0; j< grid.length; j++) {
                if(columnFirst + 1 < grid[0].length  && grid[j][columnFirst] == 1 && grid[j][columnFirst + 1] == 1) {
                    columnFirst++;
                    count ++;
                } else if(columnFirst -1  >= 0 && columnFirst < grid[0].length && grid[j][columnFirst -1] == -1 && grid[j][columnFirst] == -1) {
                    columnFirst--;
                    count++;
                } else {
                    break;
                }
            }
            if (count == grid.length) {
                result[i] = columnFirst;
            } else {
                result[i]= -1;
            }
        }
        return result;
    }
}
