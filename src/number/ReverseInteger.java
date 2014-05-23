package number;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321 
 * 
 * @author Joshua Wei
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0) return x;
        
        boolean isPositive = x > 0;
        if (!isPositive) x *= -1;
        
        int ret = 0;
        while (x > 0) {
            ret *= 10;
            ret += x % 10;
            x /= 10;
        }
        
        return isPositive ? ret : -1 * ret;
    }
}
