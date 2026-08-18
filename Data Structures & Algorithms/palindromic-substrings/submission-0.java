class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int count = 0;

        // 按 substring 长度从短到长
        for (int len = 1; len <= n; len++) {

            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                // 两端一样
                if (s.charAt(i) == s.charAt(j)) {

                    // len <= 3 时，中间最多一个字符
                    if (len <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 每发现一个 palindrome substring
                if (dp[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}