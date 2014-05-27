package tree;

import java.util.*;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * 
 * return [1,2,3]. 
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author Joshua Wei
 */
public class PreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        // recursive
        //return recursive(root, list);
        
        // iterative
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            if (tmp != null) {
                list.add(tmp.val);
                stack.push(tmp.right);
                stack.push(tmp.left);
            }
        }
        
        return list;
    }
    
    @SuppressWarnings("unused")
	private ArrayList<Integer> recursive(TreeNode node, ArrayList<Integer> list) {
        if (node == null) return list;
        list.add(node.val);
        recursive(node.left, list);
        recursive(node.right, list);
        return list;
    }
}
