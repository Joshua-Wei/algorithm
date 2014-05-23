package list;

import java.util.*;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * @author Joshua Wei
 */
public class MergeKLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null) return null;
        
        ListNode head = null;
        ListNode current = null;
        while (!lists.isEmpty()) {
            ListNode min = getMin(lists);
            if (min == null) break;
            
            ListNode tmp = min.next;
            min.next = null;
            if (tmp != null) lists.add(tmp);
            lists.remove(min);
            
            if (head == null) {
                head = min;
                current = head;
            } else {
                current.next = min;
                current = current.next;
            }
        }
        return head;
    }
    
    private ListNode getMin(ArrayList<ListNode> lists) {
        ListNode min = null;
        for (ListNode n : lists) {
            if (n == null) continue;
            if (min == null || n.val < min.val) min = n;
        }
        return min;
    }
}
