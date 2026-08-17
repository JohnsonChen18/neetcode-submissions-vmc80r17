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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //init 
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.offer(root);

        // main
        while(queue.isEmpty() == false){
            List<Integer> currLevel = new ArrayList<>();
            int currSize = queue.size();

            for(int i = 0; i < currSize; i++){
                TreeNode currNode = queue.poll();

                currLevel.add(currNode.val);

                // add child nodes
                if(currNode.left != null) queue.offer(currNode.left);
                if(currNode.right != null) queue.offer(currNode.right);
            }

            res.add(currLevel);
        }

        return res;
    }
}
