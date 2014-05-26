package array;

/**
 * Given an unsorted integer array, find the first missing positive integer. 
 * 
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2. 
 * 
 * Your algorithm should run in O(n) time and uses constant space. 
 * 
 * @author Joshua Wei
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) return 1;
        
        int i = 0;
        while (i < A.length) {
        	if (A[i] <= 0 || A[i] > A.length || A[i] == i + 1 || A[i] == A[A[i] - 1]) {
        		i++;
        	} else {
        		int swap = A[i];
        		int pos = A[i] - 1;
        		A[i] = A[pos];
        		A[pos] = swap;
        	}
        }
        
        int j = 0;
        while (j < A.length) {
        	if (A[j] != j + 1) return j + 1;
        	j++;
        }
        return A.length + 1;
    }
}
