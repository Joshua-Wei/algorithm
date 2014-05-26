package number;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * @author Joshua Wei
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        char[] c1 = reverse(num1.toCharArray());
        char[] c2 = reverse(num2.toCharArray());
        char[] c3 = new char[c1.length + c2.length + 1];
        for (int i = 0; i < c3.length; i++) c3[i] = '0';
        
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {
                int a = c1[i] - '0';
                int b = c2[j] - '0';
                int m = a * b;
                addToPos(c3, i + j, m % 10);
                addToPos(c3, i + j + 1, m / 10);
            }
        }
        
        String ret = new String(reverse(c3));
        while (ret.startsWith("0")) ret = ret.substring(1);
        return ret.length() == 0 ? "0" : ret;
    }
    
    private void addToPos(char[] chars, int pos, int add) {
        if (add == 0) return;
        int sum = (chars[pos] - '0') + add;
        chars[pos] = (char) (sum % 10 + '0');
        addToPos(chars, pos + 1, sum / 10);
    }
    
    private char[] reverse(char[] chars) {
        int low = 0;
        int high = chars.length - 1;
        while (low < high) {
            char swap = chars[low];
            chars[low++] = chars[high];
            chars[high--] = swap;
        }
        return chars;
    }
}
