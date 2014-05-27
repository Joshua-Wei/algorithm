package array;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 * 
 * @author Joshua Wei
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null || m < 0 || n < 0) return;
        if (A.length < m + n) return;
        
        int i = m - 1;
        int j = n - 1;
        
        for (int k = m + n - 1; k >= 0; k--) {
            if (j < 0) break;
            if (i < 0 || A[i] < B[j]) {
                A[k] = B[j];
                j--;
            } else {
                A[k] = A[i];
                i--;
            }
        }
    }
}
