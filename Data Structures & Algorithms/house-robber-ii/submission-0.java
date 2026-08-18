class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        // 情况1：不考虑最后一间
        int case1 = robRange(nums, 0, n - 2);

        // 情况2：不考虑第一间
        int case2 = robRange(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int robRange(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int curr = Math.max(
                prev1,           // 不偷当前房
                prev2 + nums[i]  // 偷当前房
            );

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}