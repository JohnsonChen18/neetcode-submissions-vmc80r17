class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            java.util.Arrays.fill(row, '.');
        }

        boolean[] cols = new boolean[n];          // 被占用的列
        boolean[] diag1 = new boolean[2 * n - 1]; // 主对角线 row - col + (n-1)
        boolean[] diag2 = new boolean[2 * n - 1]; // 副对角线 row + col

        backtrack(0, n, board, cols, diag1, diag2, results);
        return results;
    }

    private void backtrack(int row, int n, char[][] board,
                           boolean[] cols, boolean[] diag1, boolean[] diag2,
                           List<List<String>> results) {
        if (row == n) {                           // 所有行都放好了
            List<String> solution = new ArrayList<>();
            for (char[] r : board) {
                solution.add(new String(r));
            }
            results.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + (n - 1);          // 平移到非负下标
            int d2 = row + col;
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;                          // 冲突，跳过
            }
            // 放置皇后
            board[row][col] = 'Q';
            cols[col] = diag1[d1] = diag2[d2] = true;

            backtrack(row + 1, n, board, cols, diag1, diag2, results);

            // 撤销选择（回溯）
            board[row][col] = '.';
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }
}