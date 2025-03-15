//https://leetcode.com/problems/subtree-of-another-tree/

import util.TreeNode;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (checkSubTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean checkSubTree(TreeNode root, TreeNode subroot) {
        if (root == null && subroot == null) {
            return true;
        }
        if (root == null || subroot == null) {
            return false;
        }
        if (root.val != subroot.val) {
            return false;
        }

        return checkSubTree(root.left, subroot.left) && checkSubTree(root.right, subroot.right);
    }
}
