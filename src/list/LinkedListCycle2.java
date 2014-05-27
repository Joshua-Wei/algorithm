package list;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Follow up:
 * Can you solve it without using extra space? 
 * 
 * @author Joshua Wei
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        boolean hasCycle = false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) return null;
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return slow;
    }
}
