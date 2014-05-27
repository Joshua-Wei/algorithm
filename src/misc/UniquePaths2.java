package misc;

/**
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * 
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 * 
 * The total number of unique paths is 2.
 * 
 * Note: m and n will be at most 100.
 * 
 * @author Joshua Wei
 */
public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if (m == 0 || n == 0) return 0;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                obstacleGrid[i][j] *= -1;
            }
        }
        obstacleGrid[m - 1][n - 1] = 1;
        
        int x = m - 1;
        int y = n - 1;
        
        while (x >= 0 && y >= 0) {
            for (int i = x; i >= 0; i--) {
                if (obstacleGrid[i][y] == -1) continue;
                if (y < n - 1 && obstacleGrid[i][y + 1] > 0)
                    obstacleGrid[i][y] += obstacleGrid[i][y + 1];
                if (i < m - 1 && obstacleGrid[i + 1][y] > 0)
                    obstacleGrid[i][y] += obstacleGrid[i + 1][y];
            }
            for (int j = y - 1; j >= 0; j--) {
                if (obstacleGrid[x][j] == -1) continue;
                if (x < m - 1 && obstacleGrid[x + 1][j] > 0)
                    obstacleGrid[x][j] += obstacleGrid[x + 1][j];
                if (j < n - 1 && obstacleGrid[x][j + 1] > 0)
                    obstacleGrid[x][j] += obstacleGrid[x][j + 1];
            }
            x--;
            y--;
        }
        
        return obstacleGrid[0][0];
    }
}
