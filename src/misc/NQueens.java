package misc;

import java.util.*;

/**
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a
 * queen and an empty space respectively.
 * 
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 * [".Q..",  // Solution 1
 *  "...Q",
 *  "Q...",
 *  "..Q."],
 * 
 * ["..Q.",  // Solution 2
 *  "Q...",
 *  "...Q",
 *  ".Q.."]
 * ]
 * 
 * @author Joshua Wei
 */
public class NQueens {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        if (n > 0) {
            int[] cols = new int[n];
            solveNQueens(n, result, 0, cols);
        }
        return result;
    }
    
    private void solveNQueens(int n, ArrayList<String[]> result, int row, int[] cols) {
        if (row == n) {
            result.add(board(cols));
            return;
        }
        for (int i = 0; i < n; i++) {
            cols[row] = i;
            if (check(row, cols)) {
                solveNQueens(n, result, row + 1, cols);
            }
        }
    }
    
    private boolean check(int row, int[] cols) {
        for (int i = 0; i < row; i++) {
            if (cols[row] == cols[i]) return false;
            if (Math.abs(cols[row] - cols[i]) == row - i) return false;
        }
        return true;
    }
    
    private String[] board(int[] cols) {
        String[] board = new String[cols.length];
        for (int i = 0; i < board.length; i++) {
            String row = "";
            for (int j = 0; j < cols.length; j++) {
                if (j == cols[i]) row += "Q";
                else row += ".";
            }
            board[i] = row;
        }
        return board;
    }
}
