package list;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes
 * of the first two lists.
 * 
 * @author Joshua Wei
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val > l2.val) {
            ListNode swap = l1;
            l1 = l2;
            l2 = swap;
        }
        
        ListNode head = l1;
        while (l1.next != null && l2 != null) {
            if (l1.next.val < l2.val) {
                l1 = l1.next;
            } else {
                ListNode tmp = l2;
                l2 = l2.next;
                tmp.next = l1.next;
                l1.next = tmp;
                l1 = tmp;
            }
        }
        
        if (l1.next == null) l1.next = l2;
        
        return head;
    }
}
