package array;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * @author Joshua Wei
 */
public class SingleNumber2 {
    public int singleNumber(int[] A) {
        int[] count = new int[32];
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }
        for (int a : A) {
            for (int i = 0; i < count.length; i++) {
                count[i] += (a >> i & 1);
            }
        }
        int ret = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 3 != 0) {
                ret = ret | 1 << i;
            }
        }
        return ret;
    }
}
