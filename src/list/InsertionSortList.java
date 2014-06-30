package list;

/**
 * Sort a linked list using insertion sort.
 * 
 * @author Joshua Wei
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        return insertionSortList(head, head.next);
    }
    
    private ListNode insertionSortList(ListNode head, ListNode node) {
        if (node == null) return head;
        
        ListNode next = node.next;
        ListNode prev = null;
        ListNode curr = head;
        ListNode insert = null;
        
        while (curr != node) {
            if (insert == null && node.val < curr.val) {
                if (prev == null) insert = node;
                else insert = prev;
            }
            prev = curr;
            curr = curr.next;
        }
        
        if (insert != null) {
            prev.next = next;
            if (insert == node) {
                node.next = head;
                head = node;
            } else {
                node.next = insert.next;
                insert.next = node;
            }
        }
        
        return insertionSortList(head, next);
    }
}
