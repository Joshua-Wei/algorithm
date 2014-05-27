package array;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note:
 * You are not suppose to use the library's sort function for this problem. 
 * 
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then
 * 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * @author Joshua Wei
 */
public class SortColors {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) return;
        
        int x = 0;
        while (A[x] == 0) {
            x++;
            if (x == A.length) return;
        }
        
        int y = A.length - 1;
        while (A[y] == 2) {
            y--;
            if (y == -1) return;
        }
        
        int i = x;
        while (i <= y) {
            if (A[i] == 0) {
                if (i == x) {
                    i++;
                    x++;
                } else {
                    A[i] = A[x];
                    A[x] = 0;
                    x++;
                }
            } else if (A[i] == 1) {
                i++;
            } else if (A[i] == 2) {
                A[i] = A[y];
                A[y] = 2;
                y--;
            }
        }
    }
}
