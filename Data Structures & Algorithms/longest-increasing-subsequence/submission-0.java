class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // dp[i] = 以 nums[i] 结尾的最长递增子序列长度
        int[] dp = new int[n];

        int res = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // 至少可以只选择自己

            // 尝试把 nums[i] 接到前面某个 subsequence 后面
            for (int j = 0; j < i; j++) {

                // 严格递增，所以必须 <
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }
}