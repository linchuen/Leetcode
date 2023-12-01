package Easy;

public class No101SymmetricTree {
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

    public static boolean isSymmetric(TreeNode root) {
        StringBuilder left = new StringBuilder();
        putLeftRightMidOrderList(root, left);

        StringBuilder right = new StringBuilder();
        putRightLeftMidOrderList(root, right);
        return left.toString().equals(right.toString());
    }

    private static void putLeftRightMidOrderList(TreeNode node, StringBuilder stringBuilder) {
        if (node == null) {
            stringBuilder.append("-");
            return;
        }

        putLeftRightMidOrderList(node.left, stringBuilder);
        putLeftRightMidOrderList(node.right, stringBuilder);
        stringBuilder.append(node.val);
    }

    private static void putRightLeftMidOrderList(TreeNode node, StringBuilder stringBuilder) {
        if (node == null) {
            stringBuilder.append("-");
            return;
        }

        putRightLeftMidOrderList(node.right, stringBuilder);
        putRightLeftMidOrderList(node.left, stringBuilder);
        stringBuilder.append(node.val);
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        assert isSymmetric(node1);

        TreeNode node2 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3)));
        assert !isSymmetric(node2);
    }
}
