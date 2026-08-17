class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        // 越界 或 当前字符不匹配 → 失败
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(k)) {
            return false;
        }
        // 匹配到最后一个字符 → 成功
        if (k == word.length() - 1) {
            return true;
        }

        char tmp = board[i][j];
        board[i][j] = '#';          // 标记为已访问

        boolean found = dfs(board, word, i + 1, j, k + 1)
                     || dfs(board, word, i - 1, j, k + 1)
                     || dfs(board, word, i, j + 1, k + 1)
                     || dfs(board, word, i, j - 1, k + 1);

        board[i][j] = tmp;          // 回溯,恢复现场
        return found;
    }
}
