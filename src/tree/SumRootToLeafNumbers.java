package tree;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example, 
 *     1
 *    / \
 *   2   3
 * 
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13. 
 * 
 * Return the sum = 12 + 13 = 25. 
 * 
 * @author Joshua Wei
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
    	if (root == null) return 0;
        return sumNumbers(root, 0);
    }
    
    private int sumNumbers(TreeNode n, int sumSoFar) {
    	sumSoFar = sumSoFar * 10 + n.val;
        if (n.left == null && n.right == null) return sumSoFar;
        else if (n.left != null && n.right == null) return sumNumbers(n.left, sumSoFar);
        else if (n.left == null && n.right != null) return sumNumbers(n.right, sumSoFar);
        else return sumNumbers(n.left, sumSoFar) + sumNumbers(n.right, sumSoFar);
    }
}
