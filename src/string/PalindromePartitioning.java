package string;

import java.util.*;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *  
 * Return all possible palindrome partitioning of s. 
 * 
 * For example, given s = "aab",
 * Return 
 *   [
 *     ["aa","b"],
 *     ["a","a","b"]
 *   ]
 * 
 * @author Joshua Wei
 */
public class PalindromePartitioning {
    public ArrayList<ArrayList<String>> partition(String s) {
        if (s == null) return new ArrayList<ArrayList<String>>();
        return partition(s, 0);
    }
    
    private ArrayList<ArrayList<String>> partition(String s, int start) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        
        if (start == s.length()) {
            ArrayList<String> list = new ArrayList<String>();
            result.add(list);
        } else {
            for (int end = start; end < s.length(); end++) {
                if (isPalindrome(s, start, end)) {
                    for (ArrayList<String> list : partition(s, end + 1)) {
                        list.add(0, s.substring(start, end + 1));
                        result.add(list);
                    }
                }
            }
        }
        
        return result;
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
