package array;

import java.util.*;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position. 
 * 
 * Determine if you are able to reach the last index. 
 * 
 * For example:
 * A = [2,3,1,1,4], return true. 
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * @author Joshua Wei
 */
public class JumpGame {
    private HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) return false;
        return canJump(A, A.length - 1);
    }
    
    private boolean canJump(int[] A, int end) {
        if (end == 0) return true;
        if (map.containsKey(end)) return map.get(end);
        
        boolean canJump = false;
        for (int i = 0; i < end; i++) {
            if (A[i] >= end - i) {
                if (canJump(A, i)) {
                    canJump = true;
                    break;
                }
            }
        }
        
        map.put(end, canJump);
        return canJump;
    }
}
