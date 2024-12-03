package lc;


public class lc1373 {

    int ans = 0;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    // 0 当前值 1 sum
    private int[] dfs(TreeNode node) {
        if (node == null) return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int resSum = node.val;
        int[] leftRes = dfs(node.left);
        int[] rightRes = dfs(node.right);
        if (node.val <= leftRes[1]  && node.val >= rightRes[0]) {
            return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        }
        resSum += leftRes[2];
        resSum += rightRes[2];
        ans = Math.max(ans, resSum);
        return new int[] {Math.min(node.val, leftRes[0]), Math.max(node.val, rightRes[1]),resSum};
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
