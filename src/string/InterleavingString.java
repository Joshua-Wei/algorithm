package string;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2. 
 * 
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca", 
 * 
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false. 
 * 
 * @author Joshua Wei
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 ==  null || s3 == null) return false;
        if (s3.length() != s1.length() + s2.length()) return false;

		// isInterleave(s1.substring(0, i), s2.substring(0, j), s3.substring(0, i + j))
		boolean[][] table = new boolean[s1.length() + 1][s2.length() + 1];
		table[0][0] = true;
		for (int i = 1; i < table.length; i++) {
			table[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
			if (!table[i][0]) break;
		}
		for (int j = 1; j < table[0].length; j++) {
			table[0][j] = s2.substring(0, j).equals(s3.substring(0, j));
			if (!table[0][j]) break;
		}
		
		for (int i = 1; i < table.length; i++) {
			for (int j = 1; j < table[i].length; j++) {
				table[i][j] = (table[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
						|| (table[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
			}
		}
		
		return table[s1.length()][s2.length()];
    }
}
