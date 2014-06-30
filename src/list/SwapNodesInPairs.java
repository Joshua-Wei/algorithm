package list;

/**
 * Given a linked list, swap every two adjacent nodes and return its head. 
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3. 
 * 
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be
 * changed.
 * 
 * @author Joshua Wei
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
    	if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
