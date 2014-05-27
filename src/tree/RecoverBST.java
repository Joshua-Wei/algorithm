package tree;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure. 
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution? 
 *
 * @author Joshua Wei
 */
public class RecoverBST {
    private TreeNode n1 = null;
    private TreeNode n2 = null;
    private TreeNode prev = null;
    
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        
        inorder(root);
        
        if (n1 != null && n2 != null) {
            int swap = n1.val;
            n1.val = n2.val;
            n2.val = swap;
        }
    }
    
    private void inorder(TreeNode n) {
        if (n == null) return;
        
        inorder(n.left);
        
        if (prev != null && prev.val > n.val) {
            if (n1 == null) {
                n1 = prev;
            }
            n2 = n;
        }
        prev = n;
        
        inorder(n.right);
    }
}
