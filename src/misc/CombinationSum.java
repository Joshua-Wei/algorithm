package misc;

import java.util.*;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate
 * numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times. 
 * 
 * Note:
 * - All numbers (including target) will be positive integers.
 * - Elements in a combination (a1, a2, ... , ak) must be in non-descending order. (ie, a1 <= a2 <= ... <= ak).
 * - The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 * 
 * @author Joshua Wei
 */
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        return combinationSum(candidates, target, candidates.length - 1);
    }
    private ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target, int end) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        for (int i = end; i >= 0; i--) {
            if (candidates[i] == target) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(candidates[i]);
                result.add(list);
            } else if (candidates[i] < target) {
                for (ArrayList<Integer> list : combinationSum(candidates, target - candidates[i], i)) {
                    list.add(candidates[i]);
                    result.add(list);
                }
            }
        }
        
        return result;
    }
}
