package list;

import java.util.*;

/**
 * Definition for singly-linked list with a random pointer.
 */
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { label = x; }
};

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the
 * list or null.
 * 
 * Return a deep copy of the list. 
 * 
 * @author Joshua Wei
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode ret = new RandomListNode(head.label);
        RandomListNode current = ret;
        map.put(head, ret);
        
        while (head != null) {
            if (head.next == null) {
                current.next = null;
            } else {
                if (!map.containsKey(head.next)) {
                    map.put(head.next, new RandomListNode(head.next.label));
                }
                current.next = map.get(head.next);
            }
            
            if (head.random == null) {
                current.random = null;
            } else {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.label));
                }
                current.random = map.get(head.random);
            }
            
            head = head.next;
            current = current.next;
        }
        
        return ret;
    }
}
