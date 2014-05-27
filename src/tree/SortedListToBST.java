package tree;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * @author Joshua Wei
 */
public class SortedListToBST {
    private ListNode current;
    
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int len = getLength(head);
        current = head;
        return sortedListToBST(0, len - 1);
    }
    
    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
    
    private TreeNode sortedListToBST(int low, int high) {
        if (low > high) return null;
        
        int mid = (low + high) / 2;
        TreeNode left = sortedListToBST(low, mid - 1);
        TreeNode n = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBST(mid + 1, high);
        
        n.left = left;
        n.right = right;
        return n;
    }
}
