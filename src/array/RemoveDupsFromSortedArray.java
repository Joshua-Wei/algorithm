package array;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new
 * length.
 * 
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 * For example,
 * Given input array A = [1,1,2], 
 * 
 * Your function should return length = 2, and A is now [1,2]. 
 * 
 * @author Joshua Wei
 */
public class RemoveDupsFromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) return 0;
        int read = 0;
        int write = -1;
        while (read < A.length) {
            if (write < 0 || A[read] > A[write]) {
                write++;
                A[write] = A[read];
            }
            read++;
        }
        return write + 1;
    }
}
