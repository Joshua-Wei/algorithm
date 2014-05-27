package misc;

import java.util.*;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it
 * should invalidate the least recently used item before inserting a new item.
 * 
 * @author Joshua Wei
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, DListNode> map;
    private DListNode head = null;
    private DListNode tail = null;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, DListNode>(capacity);
    }
    
    private DListNode addToTail(int key, int val) {
    	DListNode node = new DListNode(key, val);
    	if (tail == null) {
    		tail = node;
    		head = tail;
    	} else {
    		tail.next = node;
    		node.prev = tail;
    		tail = node;
    	}
    	return node;
    }
    
    private void removeHead() {
    	if (head != null) {
    		DListNode oldHead = head;
    		head = head.next;
    		oldHead.next = null;
    		if (head == null) {
    			tail = null;
    		} else {
    			head.prev = null;
    		}
    	}
    }
    
    private void removeNode(DListNode node) {
    	if (node == head) {
    		head = node.next;
    	}
    	if (node == tail) {
    		tail = node.prev;
    	}
    	if (node.prev != null) node.prev.next = node.next;
		if (node.next != null) node.next.prev = node.prev;
		node.next = null;
		node.prev = null;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
        	int value = map.get(key).val;
            removeNode(map.get(key));
            map.put(key, addToTail(key, value));
            return value;
        } else {
        	return -1;
        }
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
        	removeNode(map.get(key));
        } else {
            if (map.size() == capacity) {
                map.remove(head.key);
                removeHead();
            }
        }
        map.put(key, addToTail(key, value));
    }
}

class DListNode {
	int key;
	int val;
	DListNode next;
	DListNode prev;
	DListNode(int k, int v) {
		key = k;
		val = v;
	}
}
