class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];   // 标记每个数是否已在当前排列中
        backtrack(nums, used, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, boolean[] used,
                           List<Integer> path, List<List<Integer>> res) {
        // 路径长度等于 nums 长度，说明凑齐了一个完整排列
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 每一层都从 0 开始遍历所有数（不像组合题那样从 start 开始）
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;          // 这个数已经用过，跳过

            used[i] = true;                 // 选它
            path.add(nums[i]);
            backtrack(nums, used, path, res);
            path.remove(path.size() - 1);   // 撤销选择
            used[i] = false;                // 恢复标记
        }
    }
}