package tree;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * 
 * Note: 
 * - You may only use constant extra space.
 * 
 * For example,
 * Given the following binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 * 
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 * 
 * @author Joshua Wei
 */
public class PopulateNextRightPointers2 {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        if (root.right != null) {
            TreeLinkNode tmp = root.next;
            while (tmp != null) {
                if (tmp.left != null) {
                    root.right.next = tmp.left;
                    break;
                }
                if (tmp.right != null) {
                    root.right.next = tmp.right;
                    break;
                }
                tmp = tmp.next;
            }
            connect(root.right);
        }
        
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                TreeLinkNode tmp = root.next;
                while (tmp != null) {
                    if (tmp.left != null) {
                        root.left.next = tmp.left;
                        break;
                    }
                    if (tmp.right != null) {
                        root.left.next = tmp.right;
                        break;
                    }
                    tmp = tmp.next;
                }
            }
            connect(root.left);
        }
    }
}
