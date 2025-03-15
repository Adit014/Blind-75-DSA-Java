//https://leetcode.com/problems/binary-tree-level-order-traversal/description/

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode pop = q.poll();
                list.add(pop.val);

                if (pop.left != null) q.add(pop.left);
                if (pop.right != null) q.add(pop.right);
            }
            result.add(list);
        }

        return result;
    }
}
