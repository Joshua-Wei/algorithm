package string;

import java.util.*;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid
 * dictionary word.
 * 
 * Return all such possible sentences. 
 * 
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"]. 
 * 
 * A solution is ["cats and dog", "cat sand dog"]. 
 * 
 * @author Joshua Wei
 */
public class WordBreak2 {
    private boolean[] unreachable; //to the end
    
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null || dict.isEmpty()) {
            return new ArrayList<String>();
        }
        
        unreachable = new boolean[s.length()];
        return wordBreak(s, 0, dict);
    }
    
    private ArrayList<String> wordBreak(String s, int start, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        
        if (start == s.length()) {
            result.add("");
        } else {
            for (int i = start + 1; i <= s.length(); i++) {
                String sub = s.substring(start, i);
                if (dict.contains(sub) && (i == s.length() || !unreachable[i])) {
                    for (String t : wordBreak(s, i, dict)) {
                        if (t.length() == 0) {
                            result.add(sub);
                        } else {
                            result.add(sub + " " + t);
                        }
                    }
                }
            }
        }
        
        if (result.isEmpty()) unreachable[start] = true;
        return result;
    }
}
