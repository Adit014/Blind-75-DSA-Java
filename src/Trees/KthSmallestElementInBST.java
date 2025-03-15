//https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

import util.TreeNode;

public class KthSmallestElementInBST {
    int answer = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return answer;
    }
    private void inorder(TreeNode node, int k) {
        if (node == null) return;
        inorder(node.left, k);
        count++;
        if (count == k) {
            answer = node.val;
            return;
        }
        inorder(node.right, k);
    }
}
