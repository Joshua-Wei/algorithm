package misc;

import java.util.*;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * 
 * @author Joshua Wei
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        
        int longest = 0;
        int validStart = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    validStart = i + 1;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        longest = Math.max(longest, i - validStart + 1);
                    } else {
                        longest = Math.max(longest, i - stack.peek());
                    }
                }
            }
        }
        
        return longest;
    }
}
