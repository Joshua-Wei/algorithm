package tree;

/**
 * Given a Binary Tree, convert it to a Doubly Linked List (DLL). The left and right pointers in nodes are to be used as
 * previous and next pointers respectively in converted DLL. The order of nodes in DLL must be same as Inorder of the
 * given Binary Tree. The first node of Inorder traversal (left most node in BT) must be head node of the DLL.
 * 
 * @author Joshua Wei
 *
 */
public class BinaryTreeToDoublyLinkedList {
	public TreeNode binaryTreeToDoublyLinkedList(TreeNode root) {
		if (root == null) return root;
		
		if (root.left != null) {
			TreeNode left = binaryTreeToDoublyLinkedList(root.left);
			while (left.right != null) left = left.right;
			left.right = root;
			root.left = left;
		}
		
		if (root.right != null) {
			TreeNode right = binaryTreeToDoublyLinkedList(root.right);
			root.right = right;
			right.left = root;
		}
		
		while (root.left != null) root = root.left;
		return root;
	}
}
