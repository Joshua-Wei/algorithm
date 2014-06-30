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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, sum, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void pathSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
        if (root == null) return;
        
        path.add(root.val);
        
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> validPath = new ArrayList<>(path.size());
                validPath.addAll(path);
                result.add(validPath);
            }
        } else {
            pathSum(root.left, sum - root.val, path, result);
            pathSum(root.right, sum - root.val, path, result);
        }
        
        path.remove(path.size() - 1);
    }
}
