class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // dp[i][j]:
        // 用 s 的前 i 个字符
        // 凑出 t 的前 j 个字符
        // 一共有多少种方法
        long[][] dp = new long[m + 1][n + 1];

        // 凑出空字符串永远有一种方法：什么都不选
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // 选择 1：不用当前 s[i - 1]
                dp[i][j] = dp[i - 1][j];

                // 选择 2：如果字符相等，
                // 可以用 s[i - 1] 匹配 t[j - 1]
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return (int) dp[m][n];
    }
}