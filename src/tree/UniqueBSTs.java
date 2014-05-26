package tree;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * For example,
 * Given n = 3, there are a total of 5 unique BST's. 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 
 * @author Joshua Wei
 */
public class UniqueBSTs {
    public int numTrees(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        
        int num = 0;
        for (int i = 1; i <= n; i++) {
            int leftNum = numTrees(i - 1);
            int rightNum = numTrees(n - i);
            if (leftNum == 0 && rightNum == 0) {
                num += 0;
            } else if (leftNum == 0) {
                num += rightNum;
            } else if (rightNum == 0) {
                num += leftNum;
            } else {
                num += leftNum * rightNum;
            }
        }
        return num;
    }
}
