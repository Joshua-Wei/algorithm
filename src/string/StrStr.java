package string;

/**
 * Implement strStr(). 
 * 
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 * 
 * @author Joshua Wei
 */
public class StrStr {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) return null;
        if (needle.length() == 0) return haystack;
        
        int idx = -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (startsWith(haystack, i, needle)) {
                idx = i;
                break;
            }
        }
        return idx == -1 ? null : haystack.substring(idx);
    }
    
    private boolean startsWith(String s1, int start, String s2) {
        for (int i = 0; i < s2.length(); i++) {
            if (s1.charAt(start + i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
