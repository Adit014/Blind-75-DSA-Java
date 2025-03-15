// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

import util.TreeNode;

public class BinaryTreeMaxSumPath {
    int maxSum = Integer.MIN_VALUE;
    public int maxSum(TreeNode root) {
        maxSum = dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftMaxPath = Math.max(dfs(root.left), 0);
        int rightMaxPath = Math.max(dfs(root.right), 0);

        int maxPathIfThisIsRoot = root.val + leftMaxPath + rightMaxPath;
        maxSum = Math.max(maxSum, maxPathIfThisIsRoot);

        return 1 + root.val + Math.max(leftMaxPath, rightMaxPath);
    }
}
