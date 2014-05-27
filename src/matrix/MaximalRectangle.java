package matrix;

import java.util.*;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 * 
 * @author Joshua Wei
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int maximal = 0;
        
        int[][] heights = convertToHeights(matrix);
        for (int[] height : heights) {
            maximal = Math.max(maximal, largestRectangleArea(height));
        }
        
        return maximal;
    }
    
    private int[][] convertToHeights(char[][] matrix) {
        int[][] heights = new int[matrix.length][];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = new int[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[i][j] = 1;
                    if (i > 0) heights[i][j] += heights[i - 1][j];
                }
            }
        }
        return heights;
    }
    
    // see largest rectangle in histogram 
    private int largestRectangleArea(int[] height) {
        int largest = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while (i < height.length || !stack.isEmpty()) {
            if (i < height.length && (stack.isEmpty() || height[i] >= height[stack.peek()])) {
                stack.push(i);
                i++;
            } else {
                int tall = height[stack.pop()];
                int right = i;
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                largest = Math.max(largest, tall * (right - left));
            }
        }
        
        return largest;
    }
}
