package array;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position. 
 * 
 * Your goal is to reach the last index in the minimum number of jumps. 
 * 
 * For example:
 * Given array A = [2,3,1,1,4] 
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.)
 * 
 * @author Joshua Wei
 */
public class JumpGame2 {
    public int jump(int[] A) {
        if (A == null || A.length == 0) return -1;
        if (A.length == 1) return 0;
        
        int count = 0;
        int start = 0;
        int end = 0;
        
        while (start < A.length) {
            count++;
            int farthest = end;
            
            for (int i = start; i <= end; i++) {
                if (i + A[i] >= A.length - 1) {
                    return count;
                }
                if (i + A[i] > farthest) {
                    farthest = i + A[i];
                }
            }
            start = end + 1;
            end = farthest;
            
            if (end < start) return -1;
        }
        
        return count;
    }
}
