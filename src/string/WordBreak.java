package string;

import java.util.*;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of
 * one or more dictionary words.
 * 
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"]. 
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author Joshua Wei
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null || dict.isEmpty()) {
            return false;
        }
        
        boolean[] reachable = new boolean[s.length()];
        reachable[0] = true;
        
        for (int i = 0; i < s.length(); i++) {
            if (!reachable[i]) continue;
            
            for (String d : dict) {
                int end = i + d.length();
                if (end <= s.length() && d.equals(s.substring(i, end))) {
                    if (end == s.length()) {
                        return true;
                    } else {
                        reachable[end] = true;
                    }
                }
            }
        }
        return false;
    }
}
