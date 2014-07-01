package array;

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
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) return false;
        
        boolean[] dp = new boolean[A.length];
        dp[0] = true;
        
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + A[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[dp.length - 1];
    }
}
