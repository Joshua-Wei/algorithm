package array;

import java.util.*;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * @author Joshua Wei
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int n : num) set.add(n);
        
        int longest = 1;
        for (int n : num) {
            if (!set.contains(n)) continue;
            
            int count = 1;
            int left = n - 1;
            int right = n + 1;
            
            while (set.contains(left)) {
                set.remove(left);
                left--;
                count++;
            }
            while (set.contains(right)) {
                set.remove(right);
                right++;
                count++;
            }
            set.remove(n);
            
            if (count > longest) longest = count;
        }
        return longest;
    }
}
