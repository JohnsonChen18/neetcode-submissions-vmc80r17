class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 每行、每列、每个宫各用一组 boolean[9] 记录 1-9 是否出现过
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;   // 空格跳过

                int num = board[r][c] - '1';         // 把 '1'-'9' 映射到 0-8
                int box = (r / 3) * 3 + (c / 3);     // 计算宫格编号

                // 只要在行、列、宫任意一处已出现,即非法
                if (rows[r][num] || cols[c][num] || boxes[box][num]) {
                    return false;
                }

                rows[r][num] = true;
                cols[c][num] = true;
                boxes[box][num] = true;
            }
        }
        return true;
    }
}