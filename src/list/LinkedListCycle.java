package list;

/**
 * Given a linked list, determine if it has a cycle in it. 
 * 
 * Follow up:
 * Can you solve it without using extra space? 
 * 
 * @author Joshua Wei
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == slow) return true;
            if (fast != null) fast = fast.next;
            if (fast == slow) return true;
            slow = slow.next;
        }
        return false;
    }
}
