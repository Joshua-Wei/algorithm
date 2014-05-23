package string;

/**
 * Given a string, find the length of the longest substring without repeating characters. For example, the longest
 * substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 * @author Joshua Wei
 */
public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        boolean[] map = new boolean[256];
        int left = 0;
        int right = 0;
        int longest = 0;

        while (right < s.length()) {
            if (map[s.charAt(right)]) {
                if (right - left > longest) longest = right - left;
                while (s.charAt(left) != s.charAt(right)) {
                    map[s.charAt(left)] = false;
                    left++;
                }
                left++;
            }
            map[s.charAt(right)] = true;
            right++;
        }

        if (right - left > longest) longest = right - left;
        return longest;
    }
}
