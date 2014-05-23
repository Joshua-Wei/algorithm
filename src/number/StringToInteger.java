package number;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front. 
 * 
 * @author Joshua Wei
 */
public class StringToInteger {
    public int atoi(String str) {
        if (str == null) return 0;
        
        int len = str.length();
        int idx = 0;
        while (idx < len && str.charAt(idx) == ' ') {
            idx++;
        }
        
        if (idx == len) return 0;
        
        int sign = 1;
        if (str.charAt(idx) == '+') {
            idx++;
        } else if (str.charAt(idx) == '-') {
            sign = -1;
            idx++;
        }
        
        if (idx == len || str.charAt(idx) < '0' || str.charAt(idx) > '9')
            return 0;
        
        int val = 0;
        while (idx < len) {
            if (str.charAt(idx) < '0' || str.charAt(idx) > '9') break;
            
            if (val > 214748364) {
            	return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            if (val == 214748364) {
            	if (sign > 0 && str.charAt(idx) > '7') return Integer.MAX_VALUE;
            	if (sign < 0 && str.charAt(idx) > '8') return Integer.MIN_VALUE;
            }
            val = val * 10 + (str.charAt(idx) - '0');

            idx++;
        }

        return sign * val;
    }
}
