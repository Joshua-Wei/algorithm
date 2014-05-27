package misc;

import java.util.*;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * Return 
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * 
 * @author Joshua Wei
 */
public class PascalsTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> rows = new ArrayList<ArrayList<Integer>>();
        if (numRows > 0) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int i = 0; i < numRows; i++) {
                rows.add(row);
                row = nextRow(row);
            }
        }
        return rows;
    }
    
    private ArrayList<Integer> nextRow(ArrayList<Integer> row) {
        ArrayList<Integer> nextRow = new ArrayList<Integer>();
        nextRow.add(row.get(0));
        for (int i = 1; i < row.size(); i++) {
            nextRow.add(row.get(i - 1) + row.get(i));
        }
        nextRow.add(row.get(row.size() - 1));
        return nextRow;
    }
}
