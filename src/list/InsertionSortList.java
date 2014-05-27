package list;

/**
 * Sort a linked list using insertion sort.
 * 
 * @author Joshua Wei
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        head = doFirst(head);

        ListNode lastSorted = head;
        while (lastSorted.next != null) {
            ListNode prev = lastSorted;
            ListNode min = lastSorted.next;
            
            ListNode tmp = lastSorted;
            while (tmp.next != null) {
                if (tmp.next.val < min.val) {
                    prev = tmp;
                    min = tmp.next;
                }
                tmp = tmp.next;
            }
            
            
            prev.next = min.next;
            min.next = lastSorted.next;
            lastSorted.next = min;
            lastSorted = lastSorted.next;
        }
        return head;
    }
    
    public ListNode doFirst(ListNode head) {
        ListNode prev = null;
        ListNode min = head;
        
        ListNode tmp = head;
        while (tmp.next != null) {
            if (tmp.next.val < min.val) {
                prev = tmp;
                min = tmp.next;
            }
            tmp = tmp.next;
        }
        
        if (min != head) {
            prev.next = min.next;
            min.next = head;
        }
        return min;
    }
}
