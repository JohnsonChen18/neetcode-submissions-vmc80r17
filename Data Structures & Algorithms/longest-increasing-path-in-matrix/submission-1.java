class Solution {

    private int rows;
    private int cols;
    private int[][] matrix;
    private int[][] memo;

    private final int[][] dirs = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        rows = matrix.length;
        cols = matrix[0].length;

        // memo[r][c]:
        // 从 (r, c) 出发的最长 increasing path
        memo = new int[rows][cols];

        int res = 0;

        // 尝试每一个 cell 作为起点
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                res = Math.max(res, dfs(r, c));
            }
        }

        return res;
    }

    private int dfs(int r, int c) {

        // 已经计算过
        if (memo[r][c] != 0) {
            return memo[r][c];
        }

        // 至少包含自己
        int maxLen = 1;

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            // 越界
            if (nr < 0 || nr >= rows ||
                nc < 0 || nc >= cols) {
                continue;
            }

            // 必须 strictly increasing
            if (matrix[nr][nc] <= matrix[r][c]) {
                continue;
            }

            maxLen = Math.max(
                maxLen,
                1 + dfs(nr, nc)
            );
        }

        memo[r][c] = maxLen;

        return maxLen;
    }
}