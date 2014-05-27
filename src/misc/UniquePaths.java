package misc;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * @author Joshua Wei
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m < 0 || n < 0) return 0;
        
        int[][] matrix = new int[m][n];
        
        int x = m - 1;
        int y = n - 1;
        while (x >= 0 && y >= 0) {
            for (int i = x; i >= 0; i--) {
                if (i == m - 1 || y == n - 1) matrix[i][y] = 1;
                else matrix[i][y] = matrix[i + 1][y] + matrix[i][y + 1];
            }
            for (int j = y; j >= 0; j--) {
                if (x == m - 1 || j == n - 1) matrix[x][j] = 1;
                else matrix[x][j] = matrix[x + 1][j] + matrix[x][j + 1];
            }
            x--;
            y--;
        }
        
        return matrix[0][0];
    }
}
