package tree;

import java.util.*;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level
 * by level from leaf to root).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * 
 * @author Joshua Wei
 */
public class LevelOrderTraversal2 {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) return ret;
        
        Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        
        Queue<TreeNode> current = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        current.offer(root);
        
        while (true) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            while (!current.isEmpty()) {
                TreeNode n = current.poll();
                level.add(n.val);
                if (n.left != null) next.offer(n.left);
                if (n.right != null) next.offer(n.right);
            }
            stack.push(level);
            
            if (next.isEmpty()) break;
            
            Queue<TreeNode> swap = current;
            current = next;
            next = swap;
        }
        
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        
        return ret;
    }
}
