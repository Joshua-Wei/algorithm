package misc;

import java.util.*;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is: 
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()" 
 * 
 * @author Joshua Wei
 *
 */
public class GenerateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
        return generateParenthesis(n, n);
    }
    
    private ArrayList<String> generateParenthesis(int numLeft, int numRight) {
        ArrayList<String> ret = new ArrayList<String>();
        
        if (numRight <= 0) {
            ret.add("");
            return ret;
        }
        
        if (numLeft == 0) {
            String s = "";
            for (int i = 0; i < numRight; i++) s += ")";
            ret.add(s);
            return ret;
        }
        
        for (String s : generateParenthesis(numLeft - 1, numRight)) {
            ret.add("(" + s);
        }
        
        if (numLeft < numRight) {
            for (String s : generateParenthesis(numLeft, numRight - 1)) {
                ret.add(")" + s);
            }
        }
        return ret;
    }
}
