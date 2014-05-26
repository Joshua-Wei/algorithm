package misc;

import java.util.*;

/**
 * Given a collection of numbers, return all possible permutations. 
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. 
 * 
 * @author Joshua Wei
 */
public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num != null && num.length > 0) permute(num, 0, result);
        return result;
    }
    
    private void permute(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
        if (start == num.length - 1) {
            ArrayList<Integer> permutation = new ArrayList<Integer>();
            for (int i = 0; i < num.length; i++) permutation.add(num[i]);
            result.add(permutation);
            return;
        }
        
        for (int i = start; i < num.length; i++) {
            int swap = num[start];
            num[start] = num[i];
            num[i] = swap;
            
            permute(num, start + 1, result);
            
            num[i] = num[start];
            num[start] = swap;
        }
    }
}
