package string;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") -> false
 * isMatch("aa","aa") -> true
 * isMatch("aaa","aa") -> false
 * isMatch("aa", "*") -> true
 * isMatch("aa", "a*") -> true
 * isMatch("ab", "?*") -> true
 * isMatch("aab", "c*a*b") -> false
 *
 * @author Joshua Wei
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
    	if (s == null && p == null) return true;
    	if (s == null || p == null) return false;
    	
    	int pCount = 0;
    	for (int i = 0; i < p.length(); i++) {
    		if (p.charAt(i) != '*') pCount++;
    	}
    	if (s.length() < pCount) return false;
        
    	// isMatch(s.substring(0, i), p.substring(0, j))
    	boolean[][] table = new boolean[s.length() + 1][p.length() + 1];
    	table[0][0] = true;
    	
    	for (int j = 1; j <= p.length(); j++) {
    		table[0][j] = table[0][j - 1] && p.charAt(j - 1) == '*';
    		if (!table[0][j]) break;
    	}
    	
    	for (int i = 1; i <= s.length(); i++) {
    		for (int j = 1; j <= p.length(); j++) {
    			char c = p.charAt(j - 1);
    			if (c == '*') {
    				table[i][j] = table[i][j - 1] || table[i - 1][j];
    			} else if (c == '?') {
    				table[i][j] = table[i - 1][j - 1];
    			} else {
    				table[i][j] = table[i - 1][j - 1] && s.charAt(i - 1) == c;
    			}
    		}
    	}
    	
    	return table[s.length()][p.length()];
    }
}
