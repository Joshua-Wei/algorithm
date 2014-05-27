package array;

/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * @author Joshua Wei
 */
public class SearchRotatedSortedArray2 {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) return false;
        
        int low = 0;
        int high = A.length - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) return true;
            
            int mid1 = mid;
            while (mid1 > low && A[mid1 - 1] == A[mid1]) {
            	mid1--;
            }
            
            int mid2 = mid;
            while (mid2 < high && A[mid2 + 1] == A[mid2]) {
            	mid2++;
            }
            
            if (mid1 == low && mid2 == high) return false;
            if (mid1 == low) {
            	low = mid2 + 1;
            	continue;
            }
            if (mid2 == high) {
            	high = mid1 - 1;
            	continue;
            }
            
            if (target < A[mid1]) {
                if (A[mid2] <= A[high] || target >= A[low]) {
                    high = mid1 - 1;
                } else {
                    low = mid2 + 1;
                }
            } else if (target > A[mid2]) {
                if ((A[low] <= A[mid1]) || target <= A[high]) {
                    low = mid2 + 1;
                } else {
                    high = mid1 - 1;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
