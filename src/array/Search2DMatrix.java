package array;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * - Integers in each row are sorted from left to right.
 * - The first integer of each row is greater than the last integer of the previous row.
 *  
 * For example,
 * 
 * Consider the following matrix: 
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * 
 * Given target = 3, return true.
 * 
 * @author Joshua Wei
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int lowRow = 0;
        int highRow = matrix.length - 1;
        int row = -1;
        while (lowRow <= highRow) {
            int midRow = (lowRow + highRow) / 2;
            if (matrix[midRow][0] <= target) {
                if (midRow == matrix.length - 1
                        || matrix[midRow + 1][0] > target) {
                    row = midRow;
                    break;
                } else {
                    lowRow = midRow + 1;
                }
            } else {
                highRow = midRow - 1;
            }
        }
        
        if (row == -1) return false;
        
        int lowCol = 0;
        int highCol = matrix[0].length - 1;
        while (lowCol <= highCol) {
            int midCol = (lowCol + highCol) / 2;
            if (matrix[row][midCol] > target) {
                highCol = midCol - 1;
            } else if (matrix[row][midCol] < target) {
                lowCol = midCol + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
