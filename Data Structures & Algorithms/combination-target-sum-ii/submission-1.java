class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // 关键：先排序，让相同的数字挨在一起，方便后面做同层去重
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int remain, int start,
                           List<Integer> path, List<List<Integer>> res) {
        if (remain == 0) {                        // 刚好凑够，记录这条组合
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 排序后，如果当前数 > remain，后面只会更大，直接 break 剪枝
            if (candidates[i] > remain) break;

            // ★ 同层去重：i > start 说明是在同一层的循环里；
            //   如果这个数和它前一个相同，前一个已经把所有情况都试过了，跳过
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            path.add(candidates[i]);              // 选 candidates[i]
            // 传 i+1：每个元素最多用一次，不能再选自己
            backtrack(candidates, remain - candidates[i], i + 1, path, res);
            path.remove(path.size() - 1);         // 撤销选择
        }
    }
}