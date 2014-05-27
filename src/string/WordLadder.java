package string;

import java.util.*;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to
 * end, such that:
 * 1.Only one letter can be changed at a time
 * 2.Each intermediate word must exist in the dictionary
 * 
 * For example, 
 * 
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5. 
 * 
 * Note:
 * - Return 0 if there is no such transformation sequence.
 * - All words have the same length.
 * - All words contain only lowercase alphabetic characters.
 * 
 * @author Joshua Wei
 */
public class WordLadder {
    public int ladderLength(String start, String end, HashSet<String> dict) {
    	if (start == null || end == null || dict == null) return 0;
    	
    	Queue<String> currentLevel = new LinkedList<String>();
    	Queue<String> nextLevel = new LinkedList<String>();
    	currentLevel.offer(start);
    	int level = 0;
    	
    	while (!currentLevel.isEmpty()) {
    		level++;
    		while (!currentLevel.isEmpty()) {
	    		String currentWord = currentLevel.poll();
	    		char[] currentChars = currentWord.toCharArray();
	    		
	    		for (int i = 0; i < currentChars.length; i++) {
	    			char tmp = currentChars[i];
	    			for (char c = 'a'; c <= 'z'; c++) {
	    				currentChars[i] = c;
	    				String nextWord = new String(currentChars);
	    	    		
	    	    		if (nextWord.equals(end)) return level + 1;
	    	    		if (dict.contains(nextWord)) {
	    	    			nextLevel.offer(nextWord);
	    	    			dict.remove(nextWord);
	    	    		}
	    			}
	    			currentChars[i] = tmp;
	    		}
	    		
    		}
    		Queue<String> swap = currentLevel;
    		currentLevel = nextLevel;
    		nextLevel = swap;
    	}
 
        return 0;
    }
}
