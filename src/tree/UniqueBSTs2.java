package tree;

import java.util.*;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * 
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below. 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 
 * @author Joshua Wei
 */
public class UniqueBSTs2 {
    public ArrayList<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            list.add(null);
            return list;
        }
        return generateTrees(1, n);
    }
    
    private ArrayList<TreeNode> generateTrees(int low, int high) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        
        if (low == high) {
            list.add(new TreeNode(low));
        } else if (low < high) {
            for (int i = low; i <= high; i++) {
                ArrayList<TreeNode> leftList = generateTrees(low, i - 1);
                ArrayList<TreeNode> rightList = generateTrees(i + 1, high);
                
                if (!leftList.isEmpty() && !rightList.isEmpty()) {
                    for (TreeNode left : leftList) {
                        for (TreeNode right : rightList) {
                            TreeNode node = new TreeNode(i);
                            node.left = left; //left.clone()
                            node.right = right; //right.clone()
                            list.add(node);
                        }
                    }
                } else if (!leftList.isEmpty() && rightList.isEmpty()) {
                    for (TreeNode left : leftList) {
                        TreeNode node = new TreeNode(i);
                        node.left = left; //left.clone()
                        list.add(node);
                    }
                } else if (leftList.isEmpty() && !rightList.isEmpty()) {
                    for (TreeNode right : rightList) {
                        TreeNode node = new TreeNode(i);
                        node.right = right; //right.clone()
                        list.add(node);
                    }
                }
            }
        }
        
        return list;
    }
}
