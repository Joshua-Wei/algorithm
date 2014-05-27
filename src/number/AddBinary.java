package number;

/**
 * Given two binary strings, return their sum (also a binary string). 
 * 
 * For example,
 * a = "11"
 * b = "1"
 * Return "100". 
 * 
 * @author Joshua Wei
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null && b == null) return null;
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;
        
        String c = "";
        
        int x = a.length() - 1;
        int y = b.length() - 1;
        int carried = 0;
        
        while (x >= 0 || y >= 0 || carried > 0) {
            int sum = carried;
            if (x >= 0 && y >= 0) {
                sum += (a.charAt(x) - '0') + (b.charAt(y) - '0');
            } else if (x >= 0 && y < 0) {
                sum += a.charAt(x) - '0';
            } else if (x < 0 && y >= 0) {
                sum += b.charAt(y) - '0';
            }
            c = (sum % 2) + c;
            carried = sum / 2;
            x--;
            y--;
        }
        
        return c;
    }
}
