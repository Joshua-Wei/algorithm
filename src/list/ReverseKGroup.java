package list;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example,
 * Given this linked list: 1->2->3->4->5 
 * 
 * For k = 2, you should return: 2->1->4->3->5 
 * 
 * For k = 3, you should return: 3->2->1->4->5 
 * 
 * @author Joshua Wei
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        
        ListNode prev = null;
        ListNode current = head;
        
        while (canReverse(current, k)) {
            for (int i = 1; i < k; i++) {
                ListNode tmp = current.next;
                current.next = tmp.next;
                if (prev == null) {
                	tmp.next = head;
                	head = tmp;
                }
                else {
                	tmp.next = prev.next;
                	prev.next = tmp;
                }
            }
            prev = current;
            current = current.next;
        }
        
        
        return head;
    }
    
    private boolean canReverse(ListNode node, int k) {
        for (int i = 0; i < k; i++) {
            if (node == null) return false;
            node = node.next;
        }
        return true;
    }
}
