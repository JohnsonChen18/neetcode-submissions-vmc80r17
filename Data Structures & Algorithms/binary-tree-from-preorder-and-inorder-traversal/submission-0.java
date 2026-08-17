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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return build(preorder, new int[]{0}, 0, inorder.length - 1, inMap);
    }

    private TreeNode build(int[] preorder, int[] preIdx, int left, int right,
                           Map<Integer, Integer> inMap) {
        if (left > right) return null;
        int rootVal = preorder[preIdx[0]++];
        TreeNode root = new TreeNode(rootVal);
        int mid = inMap.get(rootVal);
        root.left  = build(preorder, preIdx, left, mid - 1, inMap);
        root.right = build(preorder, preIdx, mid + 1, right, inMap);
        return root;
    }
}
