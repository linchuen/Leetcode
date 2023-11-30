package Category.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        int level = 1;

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        result.add(List.of(root.val));

        bfs(level + 1, root.left, result);
        bfs(level + 1, root.right, result);
        return result;
    }

    private void bfs(int level, TreeNode node, List<List<Integer>> result) {
        if (node == null) return;

        if (level > result.size()) {
            result.add(new LinkedList<>());
        }
        result.get(level - 1).add(node.val);
        bfs(level + 1, node.left, result);
        bfs(level + 1, node.right, result);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
