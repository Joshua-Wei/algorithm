package array;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The
 * overall run time complexity should be O(log (m+n)).
 * 
 * @author Joshua Wei
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        if (A == null || B == null) return 0;
        if (A.length == 0 && B.length == 0) return 0;
        
        if ((A.length + B.length) % 2 == 0) {
            int k1 = (A.length + B.length) / 2;
            int k2 = k1 - 1;
            return (findKth(A, 0, A.length - 1, B, 0, B.length - 1, k1) + findKth(A, 0, A.length - 1, B, 0, B.length - 1, k2)) / 2.0;
        } else {
            int k = (A.length + B.length) / 2;
            return findKth(A, 0, A.length - 1, B, 0, B.length - 1, k);
        }
    }
    
    private int findKth(int A[], int aStart, int aEnd, int B[], int bStart, int bEnd, int k) {
        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;
        
        if (aLen <= 0) return B[bStart + k];
        if (bLen <= 0) return A[aStart + k];
        if (k == 0) return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
        
        int aOffset = k * aLen / (aLen + bLen);
        int bOffset = k - aOffset - 1;
        
        // these are not mathematical mid points
        // but it is guaranteed that there're k elements combined left of the mid points
        int aMid = aStart + aOffset;
        int bMid = bStart + bOffset;
        
        if (A[aMid] < B[bMid]) {
            aStart = aMid + 1;
            bEnd = bMid;
            k -= aOffset + 1;
        } else {
            bStart = bMid + 1;
            aEnd = aMid;
            k -= bOffset + 1;
        }
        return findKth(A, aStart, aEnd, B, bStart, bEnd, k);
    }
}
