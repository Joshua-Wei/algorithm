package tree;

import java.util.*;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 
 * 
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 
 * @author Joshua Wei
 */
public class LevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) return ret;
        
        LinkedList<TreeNode> currentLevel = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
        currentLevel.offer(root);
        
        while (true) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            while (!currentLevel.isEmpty()) {
                TreeNode n = currentLevel.poll();
                level.add(n.val);
                if (n.left != null) nextLevel.offer(n.left);
                if (n.right != null) nextLevel.offer(n.right);
            }
            ret.add(level);
            
            if (nextLevel.isEmpty()) break;
            
            LinkedList<TreeNode> swap = currentLevel;
            currentLevel = nextLevel;
            nextLevel = swap;
        }
        return ret;
    }
}
