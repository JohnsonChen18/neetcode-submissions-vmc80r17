class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // 两边补 1
        int[] arr = new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        // dp[left][right]:
        // 戳掉 left 和 right 之间所有气球的最大收益
        int[][] dp = new int[n + 2][n + 2];

        // intervalLen 是 left 和 right 之间的距离
        for (int len = 2; len < n + 2; len++) {

            for (int left = 0; left + len < n + 2; left++) {

                int right = left + len;

                // 枚举最后一个被戳的气球
                for (int k = left + 1; k < right; k++) {

                    int coins =
                        dp[left][k]
                        + dp[k][right]
                        + arr[left] * arr[k] * arr[right];

                    dp[left][right] =
                        Math.max(dp[left][right], coins);
                }
            }
        }

        return dp[0][n + 1];
    }
}