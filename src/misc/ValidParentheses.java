package misc;

import java.util.*;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is
 * valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * @author Joshua Wei
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return false;
        
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                
                if (c == ')') {
                    if (stack.pop() != '(') return false;
                } else if (c == '}') {
                    if (stack.pop() != '{') return false;
                } else if (c == ']') {
                    if (stack.pop() != '[') return false;
                } else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
