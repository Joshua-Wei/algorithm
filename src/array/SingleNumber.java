package array;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * @author Joshua Wei
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) return 0; //undefined behavior
        int xor = 0;
        for (int i : A) {
            xor ^= i;
        }
        return xor;
    }
}
