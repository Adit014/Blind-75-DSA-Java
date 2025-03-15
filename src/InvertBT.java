import util.TreeNode;

// https://leetcode.com/problems/invert-binary-tree/
public class InvertBT {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n9 = new TreeNode(9);
        TreeNode n2 = new TreeNode(2, n1, n3);
        TreeNode n7 = new TreeNode(7, n6, n9);
        TreeNode n4 = new TreeNode(4, n2, n7);

        new InvertBT().invertTree(n4);
    }
    public TreeNode invertTree(TreeNode root) {
        TreeNode current = root;
        if (current != null) {
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            invertTree(current.left);
            invertTree(current.right);
        }
        return current;
    }
}
