import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromInorderAndPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int is, int ie, int ps, int pe, Map<Integer, Integer> map) {
        if (is > ie || ps > pe) return null;

        TreeNode node = new TreeNode(postorder[pe]);
        int index = map.get(postorder[pe]);
        int numsLeft = index - is;
        node.left = buildTree(inorder, postorder, is, index - 1, ps, ps + numsLeft - 1, map);
        node.right = buildTree(inorder, postorder, index + 1, ie, ps + numsLeft, pe - 1, map);
        return node;
    }
}
