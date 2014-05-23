package array;

import java.util.*;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author Joshua Wei
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        int result = Integer.MAX_VALUE;
        
        if (num != null && num.length >= 3) {
	        Arrays.sort(num);
	        for (int i = 0; i < num.length - 2; i++) {
	            int j = i + 1;
	            int k = num.length - 1;
	            
	            while (j < k) {
	                int sum = num[i] + num[j] + num[k];
	                if (result == Integer.MAX_VALUE || Math.abs(sum - target) < Math.abs(result - target)) {
	                    result = sum;
	                }
	                
	                if (sum < target) {
	                    j++;
	                } else if (sum > target) {
	                    k--;
	                } else {
	                    break;
	                }
	            }
	        }
        }
        
        return result;
    }
}
