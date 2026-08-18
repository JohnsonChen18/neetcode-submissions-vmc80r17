class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // dp[i][j]:
        // text1 前 i 个字符 和 text2 前 j 个字符的 LCS 长度
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 当前字符相同，两边一起使用
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 当前字符不同：
                    // 尝试丢掉 text1 当前字符
                    // 或丢掉 text2 当前字符
                    dp[i][j] = Math.max(
                        dp[i - 1][j],
                        dp[i][j - 1]
                    );
                }
            }
        }

        return dp[m][n];
    }
}