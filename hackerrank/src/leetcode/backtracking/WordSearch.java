package leetcode.backtracking;

public class WordSearch {

    private static boolean check = false;

    public static void main(String[] args) {

       char[][] board = {{'A','B','C','E'},
               {'S','F','C','S'},
               {'A','D','E','E'}};

//               {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
       /*
       [['A','B','C','E'],
        ['S','F','C','S'],
        ['A','D','E','E']]
        */

        System.out.println(exist(board, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
        for(int i = 0; i< board.length; i++) {
            for(int j = 0; j< board.length; j++) {
                backTracking(i, j, board, word, 0);
            }
        }
        return check;
    }

    public static void backTracking(int i, int j, char[][] board, String word, int count) {

        if(count == word.length()) {
            check = true;
            return;
        }

        if(i == board.length || j == board.length || i < 0 || j < 0 || board[i][j] != word.charAt(count)) {
            return;
        }


        char letter = board[i][j];

        board[i][j] = '#';

        if(!check) {
            backTracking(i, j + 1, board, word, count + 1);
            backTracking(i + 1, j, board, word, count + 1);
            backTracking(i , j -1, board, word, count + 1);
            backTracking(i -1, j , board, word, count + 1);
        }
        board[i][j] = letter;
    }

    public boolean exist2(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        // If all characters are matched
        if (index == word.length()) {
            return true;
        }

        // Check boundaries and character match
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Save the current cell value and mark it as visited
        char temp = board[row][col];
        board[row][col] = '#';  // mark as visited

        // Explore all 4 directions
        boolean found = dfs(board, word, row + 1, col, index + 1) || // Down
                dfs(board, word, row - 1, col, index + 1) || // Up
                dfs(board, word, row, col + 1, index + 1) || // Right
                dfs(board, word, row, col - 1, index + 1);   // Left

        // Restore the current cell's value
        board[row][col] = temp;

        return found;
    }
}
