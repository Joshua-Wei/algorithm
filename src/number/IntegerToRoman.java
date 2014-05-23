package number;

/**
 * Given an integer, convert it to a roman numeral. 
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author Joshua Wei
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        //I 	1
        //V 	5
        //X 	10
        //L 	50
        //C 	100
        //D 	500
        //M 	1,000
        
        //1000-3000 M, MM, MMM
        //100-900 C, CC, CCC, CD, D, DC, DCC, DCCC, DM
        //10-90 X, XX, XXX, XL, L, LX, LXX, LXXX, XC
        //1-9 I, II, III, IV, V, VI, VII, VIII, IX
        
        String roman = "";
        
        roman += digitToRoman(num / 1000, "M", "", "");
        roman += digitToRoman((num % 1000) / 100, "C", "D", "M");
        roman += digitToRoman((num % 100) / 10, "X", "L", "C");
        roman += digitToRoman(num % 10, "I", "V", "X");
        
        return roman;
    }
    
    private String digitToRoman(int digit, String one, String five, String ten) {
        switch (digit) {
            case 1: return one;
            case 2: return one + one;
            case 3: return one + one + one;
            case 4: return one + five;
            case 5: return five;
            case 6: return five + one;
            case 7: return five + one + one;
            case 8: return five + one + one + one;
            case 9: return one + ten;
            default: return "";
        }
    }
}
