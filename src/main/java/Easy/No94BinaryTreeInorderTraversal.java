package Easy;

import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class No94BinaryTreeInorderTraversal {
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

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new LinkedList<>();
        putIntoInorderList(root, inorderList);
        return inorderList;
    }

    private static void putIntoInorderList(TreeNode node, List<Integer> result) {
        if (node == null) return;

        putIntoInorderList(node.left, result);
        result.add(node.val);
        putIntoInorderList(node.right, result);
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, null, node2);

        List<Integer> result = inorderTraversal(node1);
        System.out.println(result);
    }
}
