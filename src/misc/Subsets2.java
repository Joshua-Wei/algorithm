package misc;

import java.util.*;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * 
 * Note:
 * - Elements in a subset must be in non-descending order.
 * - The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If S = [1,2,2], a solution is: 
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * 
 * @author Joshua Wei
 */
public class Subsets2 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        
        if (num != null && num.length > 0) {
            ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
            Arrays.sort(num);
            
            for (int i = 0; i < num.length; i++) {
                int occurrence = 1;
                while (i < num.length - 1 && num[i + 1] == num [i]) {
                    i++;
                    occurrence++;
                }
                
                ArrayList<ArrayList<Integer>> duplicates = duplicates(num[i], occurrence);
                
                
                for (ArrayList<Integer> a : list) {
                    for (ArrayList<Integer> d : duplicates) {
                        ArrayList<Integer> combo = new ArrayList<Integer>();
                        combo.addAll(a);
                        combo.addAll(d);
                        tmp.add(combo);
                    }
                }
                tmp.addAll(duplicates);
                
                list.addAll(tmp);
                tmp.clear();
            }
        }
        
        list.add(new ArrayList<Integer>());
        return list;
    }
    
    private ArrayList<ArrayList<Integer>> duplicates(int x, int n) {
        ArrayList<ArrayList<Integer>> duplicates = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int j = 1; j <= i; j++) {
                list.add(x);
            }
            duplicates.add(list);
        }
        
        return duplicates;
    }
}
