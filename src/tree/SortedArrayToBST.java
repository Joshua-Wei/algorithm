package tree;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * @author Joshua Wei
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) return null;
        return sortedArrayToBST(num, 0, num.length - 1);
    }
    
    private TreeNode sortedArrayToBST(int[] num, int low, int high) {
        if (low > high) return null;
        int mid = (low + high) / 2;
        TreeNode n = new TreeNode(num[mid]);
        n.left = sortedArrayToBST(num, low, mid - 1);
        n.right = sortedArrayToBST(num, mid + 1, high);
        return n;
    }
}
