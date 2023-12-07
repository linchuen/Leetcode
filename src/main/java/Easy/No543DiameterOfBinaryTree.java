package Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * <p>
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * The length of a path between two nodes is represented by the number of edges between them.
 */
public class No543DiameterOfBinaryTree {
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

    private static final Map<TreeNode, Integer> nodeDepthMap = new HashMap<>();

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int leftMaxDepth = findMaxDepth(root.left);
        int rightMaxDepth = findMaxDepth(root.right);
        int rootDiameter = leftMaxDepth + rightMaxDepth;

        if (leftMaxDepth > rightMaxDepth) {
            return Math.max(rootDiameter, diameterOfBinaryTree(root.left));
        } else {
            return Math.max(rootDiameter, diameterOfBinaryTree(root.right));
        }
    }

    private int findMaxDepth(TreeNode node) {
        if (node == null) return 0;

        if (nodeDepthMap.get(node) == null) {
            int maxDepth = Math.max(findMaxDepth(node.left), findMaxDepth(node.right)) + 1;
            nodeDepthMap.put(node, maxDepth);
            return maxDepth;
        }
        return nodeDepthMap.get(node);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    }
}
