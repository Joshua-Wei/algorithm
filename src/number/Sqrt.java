package number;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * @author Joshua Wei
 */
public class Sqrt {
    public int sqrt(int x) {
        if (x < 0) return 0; // throw new RuntimeException();
        
        if (x == 0) return 0;
        if (x == 1) return 1;
        
        int low = 2;
        int high = Math.min(x, 65536);
        
        while (low <= high) {
            int mid = (low + high) / 2;
            int square = mid * mid;
            if (square < 0 || square > x) {
                high = mid - 1;
            } else if (square < x) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return high;
    }
}
