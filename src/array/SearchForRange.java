package array;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4]. 
 * 
 * @author Joshua Wei
 */
public class SearchForRange {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        
        int left = searchRange(A, 0, A.length - 1, target);
        int right = left;
        
        if (left > -1) {
            int tmp;
            while ((tmp = searchRange(A, 0, left - 1, target)) != -1) {
                left = tmp;
            }
            while ((tmp = searchRange(A, right + 1, A.length - 1, target)) != -1) {
                right = tmp;
            }
        }
        
        result[0] = left;
        result[1] = right;
        
        return result;
    }
    
    private int searchRange(int[] A, int low, int high, int target) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (target < A[mid]) {
            return searchRange(A, low, mid - 1, target);
        } else if (target > A[mid]) {
            return searchRange(A, mid + 1, high, target);
        } else {
            return mid;
        }
    }
}
