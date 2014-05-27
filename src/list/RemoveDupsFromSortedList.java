package list;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3. 
 * 
 * @author Joshua Wei
 */
public class RemoveDupsFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                ListNode tmp = current.next;
                current.next = tmp.next;
                tmp.next = null;
            } else {
                current = current.next;
            }
        }
        
        return head;
    }
}
