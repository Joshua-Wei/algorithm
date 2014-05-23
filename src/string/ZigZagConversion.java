package string;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
 * display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *  
 * @author Joshua Wei
 */
public class ZigZagConversion {
	public String convert(String s, int nRows) {
        if (s == null) return null;
        if (s.isEmpty()) return "";
        if (nRows == 1) return s;
        
        String[] rows = new String[nRows];
        for (int i = 0; i < nRows; i++) {
            rows[i] = "";
        }
        
        boolean reverse = false;
        for (int i = 0; i < s.length();) {
        	if (!reverse) {
        		for (int j = 0; j < nRows; j++) {
        			if (i == s.length()) break;
                    rows[j] += s.charAt(i);
                    i++;
        		}
        	} else {
        		for (int j = nRows - 2; j >= 1; j--) {
        			if (i == s.length()) break;
                    rows[j] += s.charAt(i);
                    i++;
        		}
        	}
            reverse = !reverse;
        }
        
        String ret = "";
        for (String r : rows) ret += r;
        return ret;
    }
}
