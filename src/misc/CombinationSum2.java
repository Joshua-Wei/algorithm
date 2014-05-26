package misc;

import java.util.*;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the
 * candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination. 
 * 
 * Note:
 * - All numbers (including target) will be positive integers.
 * - Elements in a combination (a1, a2, ... , ak) must be in non-descending order. (ie, a1 <= a2 <= ... <= ak).
 * - The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 * 
 * @author Joshua Wei
 */
public class CombinationSum2 {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if (num == null) return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        return combinationSum2(num, target, num.length - 1);
    }
    
    private ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target, int end) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        while (end >= 0) {
        	int newEnd = end - 1;
        	while (newEnd >= 0 && num[newEnd] == num[end]) newEnd--;
        	
        	if (num[end] == target) {
        		ArrayList<Integer> list = new ArrayList<Integer>();
        		list.add(num[end]);
        		result.add(list);
        	} else if (num[end] < target) {
        		ArrayList<Integer> tmp = new ArrayList<Integer>();
        		int newTarget = target;
        		for (int j = end; j > newEnd; j--) {
        			tmp.add(num[j]);
        			newTarget -= num[j];
        			if (newTarget == 0) {
        				result.add(tmp);
        				break;
        			}
        			for (ArrayList<Integer> list : combinationSum2(num, newTarget, newEnd)) {
        				list.addAll(tmp);
        				result.add(list);
        			}
        		}
        	}
            
            end = newEnd;
        }
        
        return result;
    }
}
