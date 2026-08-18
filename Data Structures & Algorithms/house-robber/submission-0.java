class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][2];

        // 第 0 间房
        dp[0][0] = 0;       // 不偷
        dp[0][1] = nums[0]; // 偷

        for (int i = 1; i < n; i++) {
            // 当前不偷
            dp[i][0] = Math.max(
                dp[i - 1][0],
                dp[i - 1][1]
            );

            // 当前偷
            dp[i][1] = dp[i - 1][0] + nums[i];
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}