package number;

import java.util.*;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A
 * gray code sequence must begin with 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 
 * Note:
 * For a given n, a gray code sequence is not uniquely defined. 
 * 
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * 
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * 
 * @author Joshua Wei
 */
public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int code = 0;
        for (int i = 1; i <= Math.pow(2, n); i++) {
            list.add(code);
            code = grayCode(code, i);
        }
        return list;
    }
    
    private int grayCode(int last, int k) {
        int mask = 1;
        while (k % 2 == 0) {
            mask = mask << 1;
            k /= 2;
        }
        return last ^ mask;
    }
}
