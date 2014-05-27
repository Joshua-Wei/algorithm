package tree;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree. 
 * 
 * @author Joshua Wei
 */
public class ConstructFromInorderPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        if (inorder.length != postorder.length) return null;
        if (inorder.length == 0) return null;
        
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode buildTree(int[] inorder, int inLow, int inHigh, int[] postorder, int postLow, int postHigh) {
        TreeNode node = new TreeNode(postorder[postHigh]);
        if (postLow < postHigh) {
            int idx = inLow;
            while (inorder[idx] != postorder[postHigh]) idx++;
            
            int leftLen = idx - inLow;
            int rightLen = inHigh - idx;
            
            if (leftLen > 0)
                node.left = buildTree(inorder, inLow, idx - 1, postorder, postLow, postLow + leftLen - 1);
                
            if (rightLen > 0)
                node.right = buildTree(inorder, idx + 1, inHigh, postorder, postHigh - rightLen, postHigh - 1);
        }
        return node;
    }
}
