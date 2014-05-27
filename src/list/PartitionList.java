package list;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or
 * equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5. 
 * 
 * @author Joshua Wei
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        
        ListNode bigHead = null;
        ListNode smallHead = null;
        
        ListNode bigTail = null;
        ListNode smallTail = null;
        
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                if (smallHead == null) {
                    smallHead = current;
                    smallTail = current;
                } else {
                    smallTail.next = current;
                    smallTail = smallTail.next;
                }
            } else {
                if (bigHead == null) {
                    bigHead = current;
                    bigTail = current;
                } else {
                    bigTail.next = current;
                    bigTail = bigTail.next;
                }
            }
            ListNode tmp = current;
            current = current.next;
            tmp.next = null;
        }
        
        if (smallHead == null) return bigHead;
        
        smallTail.next = bigHead;
        return smallHead;
    }
}
