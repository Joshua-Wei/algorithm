package misc;

import java.util.*;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 * 
 * @author Joshua Wei
 */
public class LetterCombinations {
    public ArrayList<String> letterCombinations(String digits) {
        if (digits == null) return null;

        ArrayList<String> list = new ArrayList<String>();
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            list = addDigit(digits.charAt(i), list);
        }
        return list;
    }
    
    private ArrayList<String> addDigit(char digit, ArrayList<String> combos) {
        ArrayList<String> list = new ArrayList<String>();
        String[] letters = fromDigit(digit);
        for (String combo : combos) {
            for (String letter : letters) {
                list.add(combo + letter);
            }
        }
        return list;
    }
    
    private String[] fromDigit(char digit) {
        switch (digit) {
            case '2': return new String[] { "a", "b", "c" };
            case '3': return new String[] { "d", "e", "f" };
            case '4': return new String[] { "g", "h", "i" };
            case '5': return new String[] { "j", "k", "l" };
            case '6': return new String[] { "m", "n", "o" };
            case '7': return new String[] { "p", "q", "r", "s" };
            case '8': return new String[] { "t", "u", "v" };
            case '9': return new String[] { "w", "x", "y", "z" };
            default: return new String[] {};
        }
    }
}
