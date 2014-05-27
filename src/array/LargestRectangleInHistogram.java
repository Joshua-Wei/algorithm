package array;

import java.util.*;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area
 * of largest rectangle in the histogram. 
 * 
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 * 
 * @author Joshua Wei
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int largest = 0;
        
        Stack<Integer> stack = new Stack<Integer>(); // index
        int i = 0;
        while (i < height.length || !stack.isEmpty()) {
            if (i < height.length && (stack.isEmpty() || height[i] >= height[stack.peek()])) {
                stack.push(i); // guarantees non-decreasing order
                i++;
            } else {
            	int tall = height[stack.pop()];
                int right = i;
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                int area = tall * (right - left);
                if (area > largest) largest = area;
            }
        }
        
        return largest;
    }
}
