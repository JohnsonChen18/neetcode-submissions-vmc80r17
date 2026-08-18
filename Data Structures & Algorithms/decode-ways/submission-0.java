class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        int[] dp = new int[n + 1];

        // 空字符串有一种“什么都不解码”的方式
        // 这个 1 是为了给后面的状态转移提供基础
        dp[0] = 1;

        // 第一个字符
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {

            // 情况 1：最后一个 digit 单独解码
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // 情况 2：最后两个 digits 一起解码
            int twoDigit =
                (s.charAt(i - 2) - '0') * 10
                + (s.charAt(i - 1) - '0');

            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}