package list;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 * @author Joshua Wei
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n < 0) return null;
        if (n == 0) return head;
        
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        
        n %= len;
        if (n == 0) return head;
        
        ListNode ret = head;
        ListNode prev = null;
        for (int i = 0; i < len - n; i++) {
            prev = ret;
            ret = ret.next;
        }
        prev.next = null;
        tail.next = head;
        
        return ret;
    }
}
