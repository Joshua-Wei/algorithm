package misc;

import java.util.*;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1]. 
 * 
 * @author Joshua Wei
 */
public class Permutations2 {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        permuteUnique(num, 0, result);
        return result;
    }
    
    private void permuteUnique(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
        if (num == null || num.length == 0) return;
        
        if (start == num.length - 1) {
            result.add(dump(num));
            return;
        }
        
        for (int i = start; i < num.length; i++) {
            if (!hasDuplicates(num, start, i)) {
                swap(num, start, i);
                permuteUnique(num, start + 1, result);
                swap(num, i, start);
            }
        }
    }
    
    private ArrayList<Integer> dump(int[] num) {
        ArrayList<Integer> dump = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++) dump.add(num[i]);
        return dump;
    }
    
    private void swap(int[] num, int x, int y) {
        int tmp = num[x];
        num[x] = num[y];
        num[y] = tmp;
    }
    
    private boolean hasDuplicates(int[] num, int x, int y) {
        for (int i = x; i < y; i++) {
            if (num[i] == num[y]) return true;
        }
        return false;
    }
}
