class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] hold = new int[n];
        int[] sold = new int[n];
        int[] rest = new int[n];

        // Day 0
        hold[0] = -prices[0]; // 第一天买
        sold[0] = 0;          // 不可能卖，但设 0 即可
        rest[0] = 0;          // 什么都不做

        for (int i = 1; i < n; i++) {

            // 今天继续持有，或者今天买
            hold[i] = Math.max(
                hold[i - 1],
                rest[i - 1] - prices[i]
            );

            // 今天卖
            sold[i] = hold[i - 1] + prices[i];

            // 今天休息 / cooldown
            rest[i] = Math.max(
                rest[i - 1],
                sold[i - 1]
            );
        }

        // 最后肯定不希望还持有股票
        return Math.max(sold[n - 1], rest[n - 1]);
    }
}