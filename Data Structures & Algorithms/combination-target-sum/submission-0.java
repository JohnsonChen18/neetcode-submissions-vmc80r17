class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int remain, int start, List<Integer> path, List<List<Integer>> res) {
        if (remain == 0) {                       // 刚好凑够，记录这条组合
            res.add(new ArrayList<>(path));
            return;
        }
        if (remain < 0) return;                  // 超了，剪枝

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);                   // 选 nums[i]
            backtrack(nums, remain - nums[i], i, path, res);  // 注意是 i，不是 i+1
            path.remove(path.size() - 1);        // 撤销
        }
    }
}