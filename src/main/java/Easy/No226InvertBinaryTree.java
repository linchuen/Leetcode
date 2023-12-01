package Easy;

public class No226InvertBinaryTree {
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

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        swapChild(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private static void swapChild(TreeNode node) {
        if (node == null) return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null), null);

        TreeNode result = invertTree(root);
    }

}
