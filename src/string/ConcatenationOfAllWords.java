package string;

import java.util.*;

/**
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of
 * substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 * 
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"] 
 * 
 * You should return the indices: [0,9].
 * (order does not matter). 
 * 
 * @author Joshua Wei
 */
public class ConcatenationOfAllWords {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
    	int wordCount = L.length;
    	int wordLength = L[0].length();
    	
        String[] substrings = new String[S.length() - wordLength + 1];
        for (int i = 0; i <= S.length() - wordLength; i++) {
        	substrings[i] = S.substring(i, i + wordLength);
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        ArrayList<String> tmp = new ArrayList<String>();
    	for (int i = 0; i <= S.length() - wordCount * wordLength; i++) {
    		tmp.clear();
    		int j = i;
    		while (j < i + wordCount * wordLength) {
    			tmp.add(substrings[j]);
    			j += wordLength;
    		}
    		if (hasAll(L, tmp)) result.add(i);
        }
        
        return result;
    }
    
    private boolean hasAll(String[] expected, List<String> actual) {
    	for (int i = 0; i < expected.length; i++) {
    		if (!actual.contains(expected[i])) return false;
    		actual.remove(expected[i]);
    	}
    	return true;
    }
}
