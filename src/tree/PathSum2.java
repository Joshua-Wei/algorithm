package tree;

import java.util.*;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * 
 * @author Joshua Wei
 */
public class PathSum2 {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        return pathSum(root, sum, new ArrayList<Integer>());
    }
    
    private ArrayList<ArrayList<Integer>> pathSum(TreeNode node, int sum, ArrayList<Integer> pathToMe) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (node != null) {
            pathToMe = copy(pathToMe);
            pathToMe.add(node.val);
            
            if (node.left == null && node.right == null && node.val == sum) {
                list.add(pathToMe);
            } else {
                list.addAll(pathSum(node.left, sum - node.val, pathToMe));
                list.addAll(pathSum(node.right, sum - node.val, pathToMe));
            }
        }
        return list;
    }
    
    private ArrayList<Integer> copy(ArrayList<Integer> list) {
        ArrayList<Integer> copy = new ArrayList<Integer>();
        for (int i : list) {
            copy.add(i);
        }
        return copy;
    }
}
