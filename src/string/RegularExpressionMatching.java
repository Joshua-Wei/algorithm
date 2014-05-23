package string;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
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
 * isMatch("aa", "a*") -> true
 * isMatch("aa", ".*") -> true
 * isMatch("ab", ".*") -> true
 * isMatch("aab", "c*a*b") -> true
 *
 * @author Joshua Wei
 */
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        return isMatch(s, 0, p, 0);
    }
    
    private boolean isMatch(String s, int sStart, String p, int pStart) {
        if (sStart == s.length() && pStart == p.length()) return true;
        if (pStart == p.length()) return false;
        
        if (sStart == s.length()) {
        	if (pStart + 1 >= p.length() || p.charAt(pStart + 1) != '*') {
        		return false;
        	}
        }
        
        if (pStart == p.length() - 1) {
            return (sStart == s.length() - 1) && (s.charAt(sStart) == p.charAt(pStart) || p.charAt(pStart) == '.');
        }
        
        if (p.charAt(pStart + 1) != '*') {
            if (s.charAt(sStart) != p.charAt(pStart) && p.charAt(pStart) != '.') return false;
            else return isMatch(s, sStart + 1, p, pStart + 1);
        } else {
            while (sStart < s.length() && (s.charAt(sStart) == p.charAt(pStart) || p.charAt(pStart) == '.')) {
                if (isMatch(s, sStart, p, pStart + 2)) return true;
                sStart++;
            }
            return isMatch(s, sStart, p, pStart + 2);
        }
    }
}
