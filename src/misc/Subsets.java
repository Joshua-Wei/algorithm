package misc;

import java.util.*;

/**
 * Given a set of distinct integers, S, return all possible subsets. 
 * 
 * Note:
 * - Elements in a subset must be in non-descending order.
 * - The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If S = [1,2,3], a solution is: 
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 
 * @author Joshua Wei
 */
public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        
        if (S != null && S.length > 0) {
            Arrays.sort(S);
            
            ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < S.length; i++) {
                for (ArrayList<Integer> a : list) {
                    ArrayList<Integer> combine = new ArrayList<Integer>();
                    combine.addAll(a);
                    combine.add(S[i]);
                    tmp.add(combine);
                }
                
                ArrayList<Integer> single = new ArrayList<Integer>();
                single.add(S[i]);
                tmp.add(single);
                
                list.addAll(tmp);
                tmp.clear();
            }
        }
        
        list.add(new ArrayList<Integer>());
        return list;
    }
}
