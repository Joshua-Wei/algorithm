package number;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * @author Joshua Wei
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return 0; // throw new RuntimException();
        if (dividend == 0) return 0;
        
        boolean isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        if (dividend > 0) dividend = 0 - dividend;
        if (divisor > 0) divisor = 0 - divisor;
        
        int result = calc(dividend, divisor);
        return isNegative ? 0 - result : result;
    }
    
    // both dividend and divisor are negative
    private int calc(int dividend, int divisor) {
        int result;
		if (dividend > divisor) {
			result = 0;
		} else {
			result = 1;
			int sum = divisor;
			while (true) {
				int twice = sum + sum;
				if (twice >= 0 || twice < dividend) break;
				sum = twice;
				result += result;
			}
	        result += divide(dividend - sum, divisor);
        }
        return result;
    }
}
