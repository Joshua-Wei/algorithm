package tree;

/**
 * Given a binary tree, determine if it is height-balanced. 
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 * 
 * @author Joshua Wei
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int getHeight(TreeNode n) {
        if (n == null) return 0;
        int leftHeight = getHeight(n.left);
        int rightHeight = getHeight(n.right);
        return (leftHeight > rightHeight) ? (leftHeight + 1) : (rightHeight + 1);
    }
}
