package number;

/**
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * 
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before
 * implementing one.
 * 
 * @author ezuawei
 */
public class ValidNumber {
    public boolean isNumber(String s) {
    	if (s == null) return false;
    	
    	int start = 0;
    	int end = s.length() - 1;
    	
    	while (start < s.length() && s.charAt(start) == ' ') start++;
    	if (start == s.length()) return false;
    	while (end >= 0 && s.charAt(end) == ' ') end--;
    	
    	if (s.charAt(start) == '+' || s.charAt(start) == '-') start++;
    	if (start > end) return false;
    	
    	int e = end;
    	while (e >= start && s.charAt(e) != 'e') e--;
    	if (e == start || e == end) return false;
    	if (e > start) {
    		int tmp = e + 1;
    		if (s.charAt(tmp) == '+' || s.charAt(tmp) == '-') tmp++;
    		if (!validateDigits(s, tmp, end)) return false;
    		end = e - 1;
    	}
    	
    	int dot = start;
    	while (dot <= end && s.charAt(dot) != '.') dot++;
    	if (dot == start && dot == end) return false;
    	if (dot <= end) {
    		if (dot < end && !validateDigits(s, dot + 1, end)) return false;
    		end = dot - 1;
    	}
    	
    	if (start <= end && !validateDigits(s, start, end)) return false;
    	return true;
    }
    
    private boolean validateDigits(String s, int start, int end) {
    	if (start > end) return false;
    	char c;
    	for (int i = start; i <= end; i++) {
    		c = s.charAt(i);
    		if (c < '0' || c > '9') return false;
    	}
    	return true;
    }
}
