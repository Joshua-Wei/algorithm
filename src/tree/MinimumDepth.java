package tree;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 
 * @author Joshua Wei
 */
public class MinimumDepth {
    private int min = Integer.MAX_VALUE;
    
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        min = Integer.MAX_VALUE;
        minDepth(root, 1);
        return min;
    }
    
    private void minDepth(TreeNode node, int level) {
        if (node.left == null && node.right == null) {
            if (level < min) {
                min = level;
            }
        } else {
            if (node.left != null) {
                minDepth(node.left, level + 1);
            }
            if (node.right != null) {
                minDepth(node.right, level + 1);
            }
        }
    }
}
