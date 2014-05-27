package misc;

import java.util.*;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row
 * below.
 * 
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 
 * 
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * 
 * @author Joshua Wei
 */
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        
        int len = triangle.size();
        int[] sum = new int[len];
        sum[0] = triangle.get(0).get(0);
        
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j >= 1; j--) {
                sum[j] = Math.min(sum[j - 1], sum[j]) + triangle.get(i).get(j);
            }
            sum[0] = sum[0] + triangle.get(i).get(0);
        }
        
        int min = sum[0];
        for (int s : sum) min = Math.min(min, s);
        return min;
    }
}
