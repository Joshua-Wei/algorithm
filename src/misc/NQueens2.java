package misc;

/**
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * 
 * @author Joshua Wei
 */
public class NQueens2 {
    private int count = 0;
    private int[] columns;
    
    public int totalNQueens(int n) {
        if (n > 0) {
            columns = new int[n];
            totalNQueens(n, 0);
        }
        return count;
    }
    
    private void totalNQueens(int n, int row) {
        if (row == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            columns[row] = i;
            if (check(row)) {
                totalNQueens(n, row + 1);
            }
        }
    }
    
    private boolean check(int row) {
        for (int i = 0; i < row; i++) {
            int diff = Math.abs(columns[row] - columns[i]);
            if (diff == 0 || diff == row - i) return false;
        }
        return true;
    }
}
