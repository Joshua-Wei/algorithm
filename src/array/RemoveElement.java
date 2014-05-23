package array;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * @author Joshua Wei
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int len = A.length;
        int i = 0;
        while (i < len) {
            if (A[i] == elem) {
                A[i] = A[len - 1];
                len--;
                continue;
            }
            i++;
        }
        return len;
    }
}
