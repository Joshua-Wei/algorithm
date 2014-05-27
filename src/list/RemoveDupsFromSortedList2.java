package list;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the
 * original list.
 * 
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3. 
 * 
 * @author Joshua Wei
 */
public class RemoveDupsFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode current = head;
        while (current != null && current.next != null) {
        	int val = current.val;
        	if (val == current.next.val) {
        		// remove nodes
        		while (current != null && current.val == val) {
        			// remove current node
        			ListNode tmp = current;
        			current = current.next;
        			tmp.next = null;
        			
        			if (prev != null) {
        				// update prev ref
        				prev.next = current;
        			} else {
        				// new head
        				head = current;
        			}
        			
        		}
        	} else {
        		// move on
        		prev = current;
        		current = current.next;
        	}
        }
        
        return head;
    }
}
