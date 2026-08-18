class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int maxLen = 1;

        // len = 当前 substring 长度
        for (int len = 1; len <= n; len++) {

            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                // 两端字符相同
                if (s.charAt(i) == s.charAt(j)) {

                    // 长度 <= 3 时，中间最多只有一个字符
                    // 所以两端一样就一定是回文
                    if (len <= 3) {
                        dp[i][j] = true;
                    } else {
                        // 否则要看里面是不是回文
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 更新最长回文
                if (dp[i][j] && len > maxLen) {
                    start = i;
                    maxLen = len;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}