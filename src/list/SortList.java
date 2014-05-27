package list;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * @author Joshua Wei
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode second = split(head);
        return merge(sortList(head), sortList(second));
    }
    
    private ListNode split(ListNode n) {
        if (n == null || n.next == null) return null;
        ListNode prev = n;
        while (n.next != null) {
            if (n.next.next == null) break;
            prev = prev.next;
            n = n.next.next;
        }
        ListNode ret = prev.next;
        prev.next = null;
        return ret;
    }
    
    private ListNode merge(ListNode n1, ListNode n2) {
        if (n1 == null && n2 == null) return null;
        if (n1 == null) return n2;
        if (n2 == null) return n1;
        if (n1.val > n2.val) {
            ListNode swap = n2;
            n2 = n1;
            n1 = swap;
        }
        ListNode ret = n1;
        while (n1.next != null) {
            if (n1.next.val < n2.val) {
                n1 = n1.next;
            } else {
                ListNode tmp = n2;
                n2 = n2.next;
                tmp.next = n1.next;
                n1.next = tmp;
                if (n2 == null) break;
            }
        }
        if (n1.next == null) n1.next = n2;
        return ret;
    }
}
