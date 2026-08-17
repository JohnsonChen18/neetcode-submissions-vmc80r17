class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));      // 拷贝当前状态，就是一个子集
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);               // 选 nums[i]
            backtrack(nums, i + 1, path, res);
            path.remove(path.size() - 1);    // 撤销选择
        }
    }
}