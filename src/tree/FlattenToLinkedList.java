package tree;

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
        if (root == null) return;
        
        TreeNode right = root.right;
        root.right = null;
        
        flatten(root.left);
        root.right = root.left;
        root.left = null;
        
        while (root.right != null) root = root.right;
        flatten(right);
        root.right = right;
    }
}
