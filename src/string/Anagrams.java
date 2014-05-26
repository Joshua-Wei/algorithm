package string;

import java.util.*;

/**
 * Given an array of strings, return all groups of strings that are anagrams. 
 * 
 * Note: All inputs will be in lower-case.
 * 
 * @author Joshua Wei
 */
public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        if (strs == null) return new ArrayList<String>();
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String str : strs) {
            String key = sort(str);
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        
        ArrayList<String> anagrams = new ArrayList<String>();
        for (String key : map.keySet()) {
            ArrayList<String> list = map.get(key);
            if (list.size() > 1) anagrams.addAll(list);
        }
        return anagrams;
    }
    
    private String sort(String s) {
        if (s == null || s.length() < 2) return s;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
