package string;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of
 * the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of
 * "ABCDE" while "AEC" is not).
 * 
 * Here is an example:
 * S = "rabbbit", T = "rabbit" 
 * Return 3. 
 * 
 * @author Joshua Wei
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        if (S == null || T == null
                || S.length() == 0 || T.length() == 0
                || S.length() < T.length()) {
            return 0;
        }
        
        // matrix for numDistinct(S.substring(0, i), T.substring(0, j))
        int[][] matrix = new int[S.length() + 1][T.length() + 1];
        for (int i = 0; i < S.length(); i++) {
        	matrix[i][0] = 1;
        }
        
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                	matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j];
                } else {
                	matrix[i][j] = matrix[i - 1][j];
                }
            }
        }
        
        return matrix[S.length()][T.length()];
    }
}
