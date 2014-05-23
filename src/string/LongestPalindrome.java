package string;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 * 
 * @author Joshua Wei
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return null;
        
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            int low = i;
            int high = i;
            while (low >= 0 && high < s.length()) {
                if (s.charAt(low) != s.charAt(high)) {
                    break;
                } else {
                    if (high - low + 1 > longest.length()) {
                        longest = s.substring(low, high + 1);
                    }
                    low--;
                    high++;
                }
            }
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
        	if (s.charAt(i) != s.charAt(i + 1)) {
        		continue;
        	}
        	
            int low = i;
            int high = i + 1;
            while (low >= 0 && high < s.length()) {
                if (s.charAt(low) != s.charAt(high)) {
                    break;
                } else {
                    if (high - low + 1 > longest.length()) {
                        longest = s.substring(low, high + 1);
                    }
                    low--;
                    high++;
                }
            }
        }
        
        return longest;
    }
}
