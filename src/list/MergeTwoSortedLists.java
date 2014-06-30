package list;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes
 * of the first two lists.
 * 
 * @author Joshua Wei
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode head;
        
        if (l1 == null && l2 == null) {
            head = null;
        } else if (l1 == null) {
            head = new ListNode(l2.val);
            head.next = mergeTwoLists(l1, l2.next);
        } else if (l2 == null) {
            head = new ListNode(l1.val);
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            if (l1.val < l2.val) {
                head = new ListNode(l1.val);
                head.next = mergeTwoLists(l1.next, l2);
            } else {
                head = new ListNode(l2.val);
                head.next = mergeTwoLists(l1, l2.next);
            }
        }
        
        return head;
    }
}
