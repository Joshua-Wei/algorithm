package string;

import java.util.*;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12). 
 * 
 * The number of ways decoding "12" is 2. 
 * 
 * @author Joshua Wei
 */
public class DecodeWays {
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public int numDecodings(String s) {
    	if (s == null || s.length() == 0) return 0;
    	
    	map.clear();
    	return numDecodings(s, 0);
    }
    
    private int numDecodings(String s, int start) {
    	if (map.containsKey(start)) return map.get(start);
        
    	int count;
        if (start == s.length() - 1) {
        	count = s.charAt(start) == '0' ? 0 : 1;
        } else if (s.charAt(start) == '0') {
        	count = 0;
        } else {
	        count = numDecodings(s, start + 1);
	        if (isValid(s.charAt(start), s.charAt(start + 1))) {
	        	if (start == s.length() - 2) count += 1;
	        	else count += numDecodings(s, start + 2);
	        }
        }
        
        map.put(start, count);
        return count;
    }
    
    private boolean isValid(char digit1, char digit2) {
        if (digit1 == '1') return true;
        if (digit1 == '2' && digit2 >= '0' && digit2 <= '6') return true;
        return false;
    }
}
