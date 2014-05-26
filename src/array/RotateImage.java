package array;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up:
 * Could you do this in-place?
 * 
 * @author Joshua Wei
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0
                || matrix.length != matrix[0].length) {
            return;
        }
        
        int x = 0;
        int y = matrix.length - 1;
        
        while (x < y) {
            int tmp;
            for (int i = 0; i < y - x; i++) {
                tmp = matrix[x][x + i];
                matrix[x][x + i] = matrix[y - i][x];
                matrix[y - i][x] = matrix[y][y - i];
                matrix[y][y - i] = matrix[x + i][y];
                matrix[x + i][y] = tmp;
            }
            x++;
            y--;
        }
    }
}
