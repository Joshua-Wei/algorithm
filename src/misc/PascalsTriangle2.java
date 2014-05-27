package misc;

import java.util.*;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3,
 * Return [1,3,3,1]. 
 * 
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space? 
 * 
 * @author Joshua Wei
 */
public class PascalsTriangle2 {
    public ArrayList<Integer> getRow(int rowIndex) {
        /*
        [
             [1],
            [1,1],
           [1,2,1],
          [1,3,3,1],
         [1,4,6,4,1]
        ]
        */
        if (rowIndex < 0) return new ArrayList<Integer>();
        
        Integer[] row = new Integer[rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            row[i] = 1;
            for (int j = i - 1; j > 0; j--) {
                row[j] += row[j - 1];
            }
            row[0] = 1;
        }

        return new ArrayList<Integer>(Arrays.asList(row));
    }
}
