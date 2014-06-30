package list;

import java.util.*;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * @author Joshua Wei
 */
public class MergeKLists {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.isEmpty()) return null;
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        
        for (ListNode list : lists) {
            if (list != null) minHeap.add(list);
        }
        
        ListNode head = null;
        ListNode tail = null;
        while (!minHeap.isEmpty()) {
            ListNode minList = minHeap.poll();
            
            if (head == null) {
                head = minList;
                tail = head;
            } else {
                tail.next = minList;
                tail = minList;
            }
            
            if (minList.next != null) minHeap.offer(minList.next);
            tail.next = null;
        }
        return head;
    }
}
