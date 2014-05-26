package misc;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ... 
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n, generate the nth sequence. 
 * 
 * Note: The sequence of integers will be represented as a string. 
 * 
 * @author Joshua Wei
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String str = null;
        for (int i = 1; i <= n; i++) {
            str = convert(str);
        }
        return str;
    }
    
    private String convert(String n) {
    	if (n == null) return "1";
    	String s = "";
        char c = n.charAt(0);
        int count = 1;
        for (int i = 1; i < n.length(); i++) {
        	if (c == n.charAt(i)) {
        		count++;
        	} else {
        		s = s + count + "" + Character.toString(c);
        		c = n.charAt(i);
        		count = 1;
        	}
        }
        return s + count + "" + Character.toString(c);
    }
}
