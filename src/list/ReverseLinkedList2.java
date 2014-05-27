package list;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass. 
 * 
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4, 
 * return 1->4->3->2->5->NULL. 
 * 
 * Note:
 * Given m, n satisfy the following condition:
 * 1 <= m <= n <= length of list. 
 * 
 * @author Joshua Wei
 */
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        
        ListNode prev = null;
        ListNode start = head;
        for (int i = 1; i < m; i++) {
            prev = start;
            start = start.next;
        }
        
        for (int i = 0; i < n - m; i++) {
            ListNode tmp = start.next;
            start.next = tmp.next;
            if (prev == null) {
                tmp.next = head;
                head = tmp;
            } else {
                tmp.next = prev.next;
                prev.next = tmp;
            }
        }
        
        return head;
    }
}
