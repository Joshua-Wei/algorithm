package tree;

import java.util.*;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then
 * right to left for the next level and alternate between).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * 
 * @author Joshua Wei
 */
public class ZigzagLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) return ret;
        
        Stack<TreeNode> currentLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        currentLevel.push(root);
        
        boolean reverse = false;
        while (true) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            while (!currentLevel.isEmpty()) {
                TreeNode n = currentLevel.pop();
                level.add(n.val);
                if (reverse) {
                    if (n.right != null) nextLevel.push(n.right);
                    if (n.left != null) nextLevel.push(n.left);
                } else {
                    if (n.left != null) nextLevel.push(n.left);
                    if (n.right != null) nextLevel.push(n.right);
                }
            }
            reverse = !reverse;
            ret.add(level);
            
            if (nextLevel.isEmpty()) break;
            
            Stack<TreeNode> swap = currentLevel;
            currentLevel = nextLevel;
            nextLevel = swap;
        }
        return ret;
    }
}
