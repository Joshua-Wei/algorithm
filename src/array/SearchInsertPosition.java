package array;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it
 * would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 -> 2
 * [1,3,5,6], 2 -> 1
 * [1,3,5,6], 7 -> 4
 * [1,3,5,6], 0 -> 0 
 * 
 * @author Joshua Wei
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) return -1;
        
        if (target <= A[0]) return 0;
        if (target == A[A.length - 1]) return A.length - 1;
        if (target > A[A.length - 1]) return A.length;
        
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == target) return i;
            if (A[i] < target && A[i + 1] > target) return i + 1;
        }
        
        return -1;
    }
}
