package tree;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree. 
 * 
 * @author Joshua Wei
 */
public class ConstructFromPreorderInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        if (preorder.length != inorder.length) return null;
        if (preorder.length == 0) return null;
        
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh) {
        TreeNode node = new TreeNode(preorder[preLow]);
        
        if (preLow != preHigh) {
            int idx = inLow;
            while (inorder[idx] != preorder[preLow]) idx++;
            
            int leftLen = idx - inLow;
            int rightLen = inHigh - idx;
            
            if (leftLen != 0)
                node.left = buildTree(preorder, preLow + 1, preLow + leftLen, inorder, inLow, idx - 1);

            if (rightLen != 0)
                node.right = buildTree(preorder, preLow + leftLen + 1, preHigh, inorder, idx + 1, inHigh);
        }
        
        return node;
    }
}
