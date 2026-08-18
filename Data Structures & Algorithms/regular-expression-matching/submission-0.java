public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[] dp = new boolean[p.length() + 1];
        dp[p.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            boolean dp1 = dp[p.length()];
            dp[p.length()] = (i == s.length());

            for (int j = p.length() - 1; j >= 0; j--) {
                boolean match = i < s.length() &&
                                (s.charAt(i) == p.charAt(j) ||
                                 p.charAt(j) == '.');
                boolean res = false;
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    res = dp[j + 2];
                    if (match) {
                        res |= dp[j];
                    }
                } else if (match) {
                    res = dp1;
                }
                dp1 = dp[j];
                dp[j] = res;
            }
        }

        return dp[0];
    }
}