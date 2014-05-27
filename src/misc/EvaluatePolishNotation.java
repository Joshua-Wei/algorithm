package misc;

import java.util.*;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation. 
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * 
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * @author Joshua Wei
 */
public class EvaluatePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                if (token.equals("+")) stack.push(operand1 + operand2);
                else if (token.equals("-")) stack.push(operand1 - operand2);
                else if (token.equals("*")) stack.push(operand1 * operand2);
                else if (token.equals("/")) stack.push(operand1 / operand2);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
    
    public boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
