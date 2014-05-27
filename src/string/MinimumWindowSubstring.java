package string;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in
 * complexity O(n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * 
 * Minimum window is "BANC". 
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 *
 * @author Joshua Wei
 */
public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        if (S == null || T == null || S.length() == 0 || T.length() == 0) return "";
        
        int[] window = new int[256];
        int[] target = new int[256];
        for (int i = 0; i < T.length(); i++) target[T.charAt(i)]++;
        
        int unseen = T.length();
        int left = 0;
        int right = 0;
        
        int minLeft = -1;
        int minLen = -1;
        
        while (right < S.length()) {
            if (target[S.charAt(right)] > 0 && window[S.charAt(right)] < target[S.charAt(right)])
            	unseen--;
            
            window[S.charAt(right)]++;
            if (unseen == 0) {
                while (window[S.charAt(left)] > target[S.charAt(left)]) {
                    window[S.charAt(left)]--;
                    left++;
                }
                if (minLen < 0 || right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
            }
            right++;
        }
        
        return minLen >= 0 ? S.substring(minLeft, minLeft + minLen) : "";
    }
}
