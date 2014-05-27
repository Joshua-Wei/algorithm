package misc;

import java.util.*;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * For example,
 * If n = 4 and k = 2, a solution is: 
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 
 * @author Joshua Wei
 */
public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) return new ArrayList<ArrayList<Integer>>();
        
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                ret.add(list);
            }
        } else if (n == k) {
            ArrayList<Integer> list = new ArrayList<Integer>(n);
            for (int i = 1; i <= n; i++) list.add(i);
            ret.add(list);
        } else {
            ret.addAll(combine(n - 1, k));
            ArrayList<ArrayList<Integer>> list = combine(n - 1, k - 1);
            for (ArrayList<Integer> l : list) l.add(n);
            ret.addAll(list);
        }
        
        return ret;
    }
}
