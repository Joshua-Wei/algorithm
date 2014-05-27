package number;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * 
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * @author Joshua Wei
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null) return null;
        if (digits.length == 0) return new int[0];
        
        int[] ret = new int[digits.length];
        boolean carried = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carried) {
                if (digits[i] == 9) {
                    ret[i] = 0;
                } else {
                    ret[i] = digits[i] + 1;
                    carried = false;
                }
            } else {
                ret[i] = digits[i];
            }
        }
        
        if (carried) {
            int[] ret2 = new int[ret.length + 1];
            ret2[0] = 1;
            System.arraycopy(ret, 0, ret2, 1, ret.length);
            ret = ret2;
        }
        
        return ret;
    }
}
