package string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * @author Joshua Wei
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        
        String prefix = "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != c) {
                    return prefix;
                }
            }
            prefix += Character.toString(c);
        }
        return prefix;
    }
}
