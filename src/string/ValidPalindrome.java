package string;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome. 
 * 
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome. 
 * 
 * @author Joshua Wei
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        
        int start = 0;
        int end = s.length() - 1;
        boolean result = true;
        while (start < end) {
            while (start < end && !isAlphanumeric(s.charAt(start))) {
                start++;
            }
            
            while (start < end && !isAlphanumeric(s.charAt(end))) {
                end--;
            }
            
            if (start == end) break;
            
            if (!equalsIgnoreCase(s.charAt(start), s.charAt(end))) {
                result = false;
                break;
            }
            start++;
            end--;
        }
        return result;
    }
    
    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c<= 'Z') || (c >= '0' && c <= '9');
    }
    
    private boolean equalsIgnoreCase(char c1, char c2) {
        int diff = c1 - c2;
        return diff == 0 || diff == 'a' - 'A' || diff == 'A' - 'a';
    }
}
