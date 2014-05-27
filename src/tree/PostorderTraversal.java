package tree;

import java.util.*;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * 
 * return [3,2,1]. 
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author Joshua Wei
 */
public class PostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        // recursive
        //recursive(root, list);
        
        // iterative
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            if (n == null) continue;
            stack2.push(n);
            stack.push(n.left);
            stack.push(n.right);
        }
        
        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }
        
        return list;
    }
    
    @SuppressWarnings("unused")
	private void recursive(TreeNode n, List<Integer> list) {
        if (n == null) return;
        recursive(n.left, list);
        recursive(n.right, list);
        list.add(n.val);
    }
}
