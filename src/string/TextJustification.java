package string;

import java.util.*;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully
 * (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra
 * spaces ' ' when necessary so that each line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not
 * divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * 
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16. 
 * 
 * Return the formatted lines as:
 * 
 * [
 *    "This    is    an",
 *   "example  of text",
 *    "justification.  "
 * ]
 * 
 * Note: Each word is guaranteed not to exceed L in length. 
 * 
 * Corner Cases: 
 * A line other than the last line might contain only one word. What should you do in this case?
 * In this case, that line should be left-justified.
 * 
 * @author Joshua Wei
 */
public class TextJustification {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>();
        
        if (words == null || words.length == 0 || L < 0) return result;
        
        ArrayList<String> tmp = new ArrayList<String>();
        int i = 0;
        while (i < words.length) {
        	int left = L;
        	tmp.clear();
        	
        	while (i < words.length) {
        		if (left < words[i].length() || (left != L && left == words[i].length())) break;
        		if (left != L) left--;
        		left -= words[i].length();
        		tmp.add(words[i++]);
        	}
        	
        	if (i == words.length) {
        		StringBuilder line = new StringBuilder();
        		line.append(getLine(tmp, 0));
        		for (int j = 0; j < left; j++) {
        			line.append(" ");
        		}
        		result.add(line.toString());
        	} else {
        		result.add(getLine(tmp, left));
        	}
        }
        
        return result;
    }
    
    private String getLine(ArrayList<String> words, int padding) {
    	StringBuilder line = new StringBuilder();
    	if (words.size() == 1) {
    		line.append(words.get(0));
    		while (padding > 0) {
    			line.append(" ");
    			padding--;
    		}
    	} else {
	    	int gap = padding / (words.size() - 1) + 1;
	    	int extra = padding % (words.size() - 1);
	    	
	    	for (int i = 0; i < words.size(); i++) {
	    		if (i != 0) {
	    			for (int j = 0; j < gap; j++) {
	    				line.append(" ");
	    			}
	    			if (extra > 0) {
	    				line.append(" ");
	    				extra--;
	    			}
	    		}
	    		line.append(words.get(i));
	    	}
    	}
    	return line.toString();
    }
}
