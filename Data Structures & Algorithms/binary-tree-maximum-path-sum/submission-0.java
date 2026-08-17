/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        // 最终答案就是整棵树的 notStart（全局最大路径和）
        return dfs(root)[1];
    }

    // 返回 int[]{start, notStart}
    //   start    : 以 node 为起点、只能向下延伸的单链最大和  —— 要往上返回给父节点
    //   notStart : node 这棵子树内部，任意路径（含拐弯）的最大和 —— 不往上拼，只上报
    private int[] dfs(TreeNode node) {
        if (node == null) {
            // 空节点：单链贡献为 0；没有任何路径，notStart 用最小值兜底
            return new int[]{0, Integer.MIN_VALUE};
        }

        int[] left  = dfs(node.left);
        int[] right = dfs(node.right);

        // 子链为负就不要（截断），和 0 取较大
        int leftStart  = Math.max(left[0],  0);
        int rightStart = Math.max(right[0], 0);

        // start：只能选左右一条链往下接，给父节点用
        int start = node.val + Math.max(leftStart, rightStart);

        // 在 node 拐弯的路径：左链 + node + 右链
        int bend = node.val + leftStart + rightStart;

        // notStart：当前拐弯值，和左右子树各自上报的 notStart，三者取最大
        int notStart = Math.max(bend, Math.max(left[1], right[1]));

        return new int[]{start, notStart};
    }
}