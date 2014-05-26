package array;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author Joshua Wei
 */
public class SearchRotatedSortedArray {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) return -1;
        return search(A, 0, A.length - 1, target);
    }
    
    public int search(int[] A, int low, int high, int target) {
        if (low > high) return -1;
        
        int mid = (low + high) / 2;
        if (target < A[mid]) {
        	if (A[mid] < A[high] || target >= A[low]) {
        		return search(A, low, mid - 1, target);
        	} else {
        		return search(A, mid + 1, high, target);
        	}
        } else if (target > A[mid]) {
        	if (A[low] < A[mid] || target <= A[high]) {
        		return search(A, mid + 1, high, target);
        	} else {
        		return search(A, low, mid - 1, target);
        	}
        } else {
        	return mid;
        }
    }
}
