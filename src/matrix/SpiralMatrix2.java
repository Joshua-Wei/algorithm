package matrix;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * For example,
 * Given n = 3, 
 * You should return the following matrix: [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * 
 * @author Joshua Wei
 */
public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][0];
        
        int[][] matrix = new int[n][n];
        int num = 0;
        
        int x = 0;
        int y = n - 1;
        
        while (x < y) {
            int i = x;
            int j = x;
            
            while (j < y) matrix[i][j++] = ++num;
            while (i < y) matrix[i++][j] = ++num;
            while (j > x) matrix[i][j--] = ++num;
            while (i > x) matrix[i--][j] = ++num;
            
            x++;
            y--;
        }
        
        if (x == y) matrix[x][x] = ++num;
        
        return matrix;
    }
}
