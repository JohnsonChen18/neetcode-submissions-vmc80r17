class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        // target 根本不可能达到
        if (Math.abs(target) > sum) {
            return 0;
        }

        int offset = sum;

        // dp[i][s + offset]:
        // 使用前 i 个数字，得到 sum = s 的方法数
        int[][] dp = new int[nums.length + 1][2 * sum + 1];

        // 0 个数字得到 sum = 0，有一种方法
        dp[0][offset] = 1;

        for (int i = 1; i <= nums.length; i++) {
            int currNum = nums[i - 1];

            for (int currSum = -sum; currSum <= sum; currSum++) {
                int ways = dp[i - 1][currSum + offset];

                if (ways == 0) {
                    continue;
                }

                // 给当前数字加 +
                dp[i][currSum + currNum + offset] += ways;

                // 给当前数字加 -
                dp[i][currSum - currNum + offset] += ways;
            }
        }

        return dp[nums.length][target + offset];
    }
}