package matrix;

import java.util.*;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
 * For example,
 * Given the following matrix: 
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 
 * You should return [1,2,3,6,9,8,7,4,5]. 
 * 
 * @author Joshua Wei
 */
public class SpiralMatrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<Integer>();
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        int x1 = 0;
        int y1 = 0;
        int x2 = matrix.length - 1;
        int y2 = matrix[0].length - 1;
        
        while (x1 < x2 && y1 < y2) {
            int i = x1;
            int j = y1;
            
            while (j < y2) list.add(matrix[i][j++]);
            while (i < x2) list.add(matrix[i++][j]);
            while (j > y1) list.add(matrix[i][j--]);
            while (i > x1) list.add(matrix[i--][j]);
            
            x1++;
            y1++;
            x2--;
            y2--;
        }
        
        if (x1 == x2) {
            for (int k = y1; k <= y2; k++) list.add(matrix[x1][k]);
        } else if (y1 == y2) {
            for (int k = x1; k <= x2; k++) list.add(matrix[k][y1]);
        }
        
        return list;
    }
}
