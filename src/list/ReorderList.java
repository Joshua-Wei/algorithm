package list;

/**
 * Given a singly linked list L: L0->L1->...->Ln-1->Ln,
 * reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->...
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}. 
 * 
 * @author Joshua Wei
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode second = split(head);
        ListNode reverse = reverse(second);
        merge(head, reverse);
    }
    
	private ListNode split(ListNode head) {
	    if (head == null || head.next == null) return null;
	    ListNode prev = null;
	    while (head != null && head.next != null) {
	        if (prev == null) prev = head;
	        else prev = prev.next;
	        head = head.next;
	        if (head != null) head = head.next;
	    }
	    ListNode ret = prev.next;
	    prev.next = null;
	    return ret;
	}
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode tmp = prev;
            prev = current;
            current = current.next;
            prev.next = tmp;
        }
        return prev;
    }
    
    private void merge(ListNode first, ListNode second) {
        if (first == null || second == null) return;
        while (first.next != null && second != null) {
            ListNode tmp = second;
            second = second.next;
            tmp.next = first.next;
            first.next = tmp;
            first = tmp.next;
        }
        if (second != null) first.next = second;
    }
}
