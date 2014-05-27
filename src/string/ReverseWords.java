package string;

/**
 * Given an input string, reverse the string word by word. 
 * 
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the". 
 * 
 * Clarification:
 * - What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * - Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * - How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 * 
 * @author Joshua Wei
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        
        char[] chars = s.toCharArray();
        
        // reverse whole string
        reverse(chars, 0, chars.length - 1);
        
        // reverse each word
        int i = 0;
        while (i < chars.length) {
            while (i < chars.length && chars[i] == ' ') i++;
            if (i == chars.length) break;
            int left = i;
            
            while (i < chars.length && chars[i] != ' ') i++;
            int right = i - 1;
            
            reverse(chars, left, right);
        }
        
        // remove extra space
        int read = 0;
        int write = 0;
        while (read < chars.length) {
        	while (read < chars.length && chars[read] == ' ') read++;
        	if (read == chars.length) break;
        	
        	if (read > 0 && chars[read - 1] == ' ' && write > 0) chars[write++] = ' ';
            chars[write++] = chars[read++];
        }
        
        return new String(chars).substring(0, write);
    }
    
    private void reverse(char[] chars, int left, int right) {
        char swap;
        while (left < right) {
            swap = chars[left];
            chars[left++] = chars[right];
            chars[right--] = swap;
        }
    }
}
