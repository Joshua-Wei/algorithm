package array;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * 
 * For example,
 * Given sorted array A = [1,1,1,2,2,3], 
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3]. 
 * 
 * @author Joshua Wei
 */
public class RemoveDupsFromSortedArray2 {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) return 0;
        
        int read = 0;
        int write1 = -1;
        int write2 = -1;
        
        while (read < A.length) {
            if (write1 < 0) {
                write1++;
                write2++;
                A[write1] = A[read];
            } else {
                if (A[read] != A[write2]) {
                    write2++;
                    A[write2] = A[read];
                    write1 = write2;
                } else if (write1 == write2) {
                    write2++;
                    A[write2] = A[read];
                }
            }
            read++;
        }
        return write2 + 1;
    }
}
