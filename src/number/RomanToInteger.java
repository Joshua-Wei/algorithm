package number;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author Joshua Wei
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        if (s == null) return 0;
        
        int num = 0;
        
        int i = 0;
        int j = 0;
        
        // thousand
        while (j < s.length() && (s.charAt(j) == 'M')) {
            j++;
        }
        num += 1000 * romanToDigit(s.substring(i, j), "M", "-", "-");
        if (j == s.length()) return num;
        
        // hundred
        i = j;
        while (j < s.length() && (s.charAt(j) == 'C' || s.charAt(j) == 'D' || s.charAt(j) == 'M')) {
            j++;
        }
        num += 100 * romanToDigit(s.substring(i, j), "C", "D", "M");
        if (j == s.length()) return num;
        
        // ten
        i = j;
        while (j < s.length() && (s.charAt(j) == 'X' || s.charAt(j) == 'L' || s.charAt(j) == 'C')) {
            j++;
        }
        num += 10 * romanToDigit(s.substring(i, j), "X", "L", "C");
        if (j == s.length()) return num;
        
        // one
        num += romanToDigit(s.substring(j, s.length()), "I", "V", "X");
        
        return num;
    }
    
    private int romanToDigit(String digit, String one, String five, String ten) {
        if (digit.equals(one)) return 1;
        else if (digit.equals(one + one)) return 2;
        else if (digit.equals(one + one + one)) return 3;
        else if (digit.equals(one + five)) return 4;
        else if (digit.equals(five)) return 5;
        else if (digit.equals(five + one)) return 6;
        else if (digit.equals(five + one + one)) return 7;
        else if (digit.equals(five + one + one + one)) return 8;
        else if (digit.equals(one + ten)) return 9;
        else return 0;
    }
}
