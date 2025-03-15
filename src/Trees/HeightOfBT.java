import util.TreeNode;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class HeightOfBT {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }
}
