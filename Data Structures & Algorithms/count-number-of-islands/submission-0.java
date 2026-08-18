class Solution {
    private int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char currChar = grid[i][j];
                if(currChar == '2' || currChar == '0') continue;
                fill(grid, i,j);
                res += 1;
            }
        }

        return res;
    }

    private void fill(char[][] grid, int x, int y){
        if(ifOnBoard(x, y, grid.length, grid[0].length) == false) return;
        if(grid[x][y] == '2' || grid[x][y] == '0') return;

        grid[x][y] = '2';

        for(int[] dir: dirs){
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            fill(grid, nextX, nextY);
        }
    }


    private boolean ifOnBoard(int x, int y, int n, int m){
        if(x < 0 || x >= n) return false;
        if(y < 0 || y >= m) return false;
        return true;
    }
}
