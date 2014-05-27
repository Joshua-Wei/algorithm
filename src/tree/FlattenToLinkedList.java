package tree;

import java.util.*;

/**
 * Given a binary tree, flatten it to a linked list in-place. 
 * 
 * For example,
 * Given 
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * 
 * The flattened tree should look like:
 *     1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * 
 * Hints: 
 * If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order
 * traversal.
 * 
 * @author Joshua Wei
 */
public class FlattenToLinkedList {
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        preorder(root, list);
        
        TreeNode prev = null;
        TreeNode current = null;
        for (int i = 0; i < list.size(); i++) {
            prev = current;
            current = list.get(i);
            current.left = null;
            current.right = null;
            if (prev != null) prev.right = current;
        }
    }
    
    private void preorder(TreeNode n, ArrayList<TreeNode> list) {
        if (n == null) return;
        list.add(n);
        preorder(n.left, list);
        preorder(n.right, list);
    }
}
