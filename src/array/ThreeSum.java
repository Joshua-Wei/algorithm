package array;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in
 * the array which gives the sum of zero.
 * 
 * Note:
 *
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)
 * The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 * 
 * @author Joshua Wei
 */
public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (num != null && num.length >= 3) {
            Arrays.sort(num);
            
            for (int i = 0; i < num.length - 2; i++) {
                if (i > 0 && num[i] == num[i - 1]) continue;
                
                int j = i + 1;
                int k = num.length - 1;
                while (j < k) {
                    if (num[i] + num[j] + num[k] < 0) {
                    	do {
                    		j++;
                    	} while (j < k && num[j] == num[j - 1]);
                    } else if (num[i] + num[j] + num[k] > 0) {
                    	do {
                    		k--;
                    	} while (j < k && num[k] == num[k + 1]);
                    } else {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[k]);
                        result.add(list);
                        
                        do {
                    		j++;
                    	} while (j < k && num[j] == num[j - 1]);
                        do {
                    		k--;
                    	} while (j < k && num[k] == num[k + 1]);
                    }
                }
            }
        }
        
        return result;
    }
}
