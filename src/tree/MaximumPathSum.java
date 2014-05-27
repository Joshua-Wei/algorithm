package tree;

/**
 * Given a binary tree, find the maximum path sum. 
 * 
 * The path may start and end at any node in the tree. 
 * 
 * For example:
 * Given the below binary tree, 
 *        1
 *       / \
 *      2   3
 * 
 * Return 6.
 * 
 * @author Joshua Wei
 */
public class MaximumPathSum {
    private int maxPathSum;
    
    public int maxPathSum(TreeNode root) {
        maxPathSum = (root == null) ? 0 : root.val;
        calcPathSum(root);
        return maxPathSum;
    }
    
    // max path terminating at node
    private int calcPathSum(TreeNode node) {
        // leaf node
        if (node == null) return 0;
        
        // discard path when sum goes below 0
        int leftMax = Math.max(0, calcPathSum(node.left));
        int rightMax = Math.max(0, calcPathSum(node.right));
        
        // update max
        maxPathSum = Math.max(maxPathSum, node.val + leftMax + rightMax);
        
        // use either path
        return node.val + Math.max(leftMax, rightMax);
    }
}
