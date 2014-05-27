package string;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * 
 * Below is one possible representation of s1 = "great": 
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * 
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * 
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 *      rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * 
 * We say that "rgeat" is a scrambled string of "great". 
 * 
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 *      rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 *  
 * We say that "rgtae" is a scrambled string of "great". 
 * 
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * 
 * @author Joshua Wei
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        if (s1.length() == 0) return true;
        return isScramble(s1, 0, s1.length(), s2, 0, s2.length());
    }
    
    private boolean isScramble(String s1, int start1, int end1, String s2, int start2, int end2) {
        int len = end1 - start1;

        if (len == 1) return s1.charAt(start1) == s2.charAt(start2);
        
        // determine if substrings have same chars (false positive is possible)
        int diff = 0;
        for (int i = 0; i < end1 - start1; i++) {
        	diff += s1.charAt(start1 + i) - s2.charAt(start2 + i);
        }
        if (diff != 0) return false;
        
        boolean ret = false;
        for (int i = 1; i < len; i++) {
            if (isScramble(s1, start1, start1 + i, s2, start2, start2 + i)
            		&& isScramble(s1, start1 + i, end1, s2, start2 + i, end2)) {
                ret = true;
                break;
            }
            if (isScramble(s1, start1, start1 + i, s2, end2 - i, end2)
            		&& isScramble(s1, start1 + i, end1, s2, start2, end2 - i)) {
                ret = true;
                break;
            }
        }
        return ret;
    }
}
