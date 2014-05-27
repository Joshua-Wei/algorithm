package tree;

import java.util.*;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 * 
 *   1
 *    \
 *     2
 *    /
 *   3
 * 
 * return [1,3,2]. 
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author Joshua Wei
 */
public class InorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        // recursively
        //inorderTraversal(root, list);
        
        // iteratively
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);
        
        while (!s1.isEmpty()) {
            TreeNode n = s1.pop();
            if (n == null) continue;
            if (!s2.isEmpty() && (n == s2.peek())) {
                list.add(n.val);
                s2.pop();
            } else {
                s1.push(n.right);
                s1.push(n);
                s1.push(n.left);
                s2.push(n);
            }
        }
        
        return list;
    }
    
    @SuppressWarnings("unused")
	private void inorderTraversal(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}
