package string;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation
 * is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word: 
 * 
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * 
 * @author Joshua Wei
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
    	if (word1 == null || word2 == null) return Integer.MAX_VALUE;
    	
    	// table for minDistance(word1.substring(0, i), word2.substring(0, j))
    	int[][] table = new int[word1.length() + 1][word2.length() + 1];
    	for (int i = 0; i <= word1.length(); i++) {
    		table[i][0] = i; // deletes
    	}
    	for (int i = 0; i <= word2.length(); i++) {
    		table[0][i] = i; // inserts
    	}
    	
    	for (int i = 1; i < table.length; i++) {
    		for (int j = 1; j < table[i].length; j++) {
    			if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
    				table[i][j] = table[i - 1][j - 1];
    			} else {
    				table[i][j] = table[i - 1][j - 1] + 1; // replace
    				table[i][j] = Math.min(table[i][j], table[i - 1][j] + 1); // delete
    				table[i][j] = Math.min(table[i][j], table[i][j - 1] + 1); // insert
    			}
    		}
    	}
    	return table[word1.length()][word2.length()];
    }
}
