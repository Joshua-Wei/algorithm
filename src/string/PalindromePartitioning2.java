package string;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s. 
 * 
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 * @author Joshua Wei
 */
public class PalindromePartitioning2 {
    public int minCut(String s) {
        if (s == null || s.length() == 0) return -1;
        
        boolean[][] matrix = buildPalindromeMatrix(s);
        int[] minPartitions = new int[s.length() + 1];
        
        for (int start = 0; start < s.length(); start++) {
            for (int end = start; end < s.length(); end++) {
                if (matrix[start][end]) {
                    if (minPartitions[end + 1] == 0 || minPartitions[start] + 1 < minPartitions[end + 1]) {
                        minPartitions[end + 1] = minPartitions[start] + 1;
                    }
                }
            }
        }
        
        return minPartitions[s.length()] - 1;

    }
    
    private boolean[][] buildPalindromeMatrix(String s) {
        boolean[][] matrix = new boolean[s.length()][];
        for (int i = 0; i < matrix.length; i++) matrix[i] = new boolean[s.length()];
        
        for (int len = 1; len <= s.length(); len++) {
            for (int left = 0; left < s.length() - len + 1; left++) {
                int right = left + len - 1;
                if (left == right) {
                    matrix[left][right] = true;
                    continue;
                }
                if (s.charAt(left) == s.charAt(right)) {
                    if (right == left + 1 || matrix[left + 1][right - 1]) {
                        matrix[left][right] = true;
                    }
                }
            }
        }
        
        return matrix;
    }
}
