package string;

import java.util.*;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * 
 * For example:
 * Given "25525511135", 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter) 
 * 
 * @author Joshua Wei
 */
public class RestoreIPAddresses {
    public ArrayList<String> restoreIpAddresses(String s) {
        if (s == null) return new ArrayList<String>();
        return restoreIpAddresses(s, 4);
    }
    
    private ArrayList<String> restoreIpAddresses(String s, int n) {
        ArrayList<String> list = new ArrayList<String>();
        
        if (n == 1) {
            if (isValid(s)) list.add(s);
        } else {
            if (s.length() >= n) {
                String sub1 = s.substring(0, 1);
                if (isValid(sub1)) {
                    String sub2 = s.substring(1, s.length());
                    for (String tmp : restoreIpAddresses(sub2, n - 1)) {
                        list.add(sub1 + "." + tmp);
                    }
                }
            }
            if (s.length() >= n + 1) {
                String sub1 = s.substring(0, 2);
                if (isValid(sub1)) {
                    String sub2 = s.substring(2, s.length());
                    for (String tmp : restoreIpAddresses(sub2, n - 1)) {
                        list.add(sub1 + "." + tmp);
                    }
                }
            }
            if (s.length() >= n + 2) {
                String sub1 = s.substring(0, 3);
                if (isValid(sub1)) {
                    String sub2 = s.substring(3, s.length());
                    for (String tmp : restoreIpAddresses(sub2, n - 1)) {
                        list.add(sub1 + "." + tmp);
                    }
                }
            }
        }
        
        return list;
    }
    
    private boolean isValid(String s) {
        boolean result = false;
        try {
            int v = Integer.valueOf(s);
            result = "0".equals(s) || (s.charAt(0) != '0' && v > 0 && v <= 255);
        } catch (Exception e) {}
        return result;
    }
}
