class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);

        int n = s.length();

        // dp[i] = 前 i 个字符能否被成功拆分
        boolean[] dp = new boolean[n + 1];

        // 空字符串视为成功拆分
        dp[0] = true;

        for (int i = 1; i <= n; i++) {

            // 尝试最后一个 word 从 j 开始
            for (int j = 0; j < i; j++) {

                // 前 j 个字符已经可以拆分
                // 并且 s[j...i-1] 是一个合法单词
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}