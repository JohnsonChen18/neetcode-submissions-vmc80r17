class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        int n = nums.length;

        // dp[i][j]:
        // 使用前 i 个数字，能不能凑出 sum = j
        boolean[][] dp = new boolean[n + 1][target + 1];

        // 凑出 0 永远可以：什么都不选
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            int curr = nums[i - 1];

            for (int j = 1; j <= target; j++) {

                // 选择 1：不用当前数字
                dp[i][j] = dp[i - 1][j];

                // 选择 2：使用当前数字
                if (j >= curr) {
                    dp[i][j] = dp[i][j]
                            || dp[i - 1][j - curr];
                }
            }
        }

        return dp[n][target];
    }
}