package array;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
 * it is able to trap after raining.
 * 
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 
 * 
 * @author Joshua Wei
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        if (A == null || A.length == 0) return 0;
        
        int sum = 0;
        
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            if (A[left] < A[right]) {
                int tmp = left + 1;
                while (tmp < A.length && A[tmp] < A[left]) {
                    sum += A[left] - A[tmp];
                    tmp++;
                }
                left = tmp;
            } else {
                int tmp = right - 1;
                while (tmp >= 0 && A[tmp] < A[right]) {
                    sum += A[right] - A[tmp];
                    tmp--;
                }
                right = tmp;
            }
        }

        return sum;
    }
}
