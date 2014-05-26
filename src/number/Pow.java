package number;

/**
 * Implement pow(x, n).
 * 
 * @author Joshua Wei
 */
public class Pow {
    public double pow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            return pow(x, n + 1) / x;
        }
        
        if (n < 0) return 1 / pow(x, 0 - n);
        if (n == 0) return 1;
        if (n == 1) return x;
        
        double v = pow(x, n / 2);
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }
}
