class Solution {
    private int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int currChar = grid[i][j];
                if(currChar == 2 || currChar == 0) continue;
                int currArea = getArea(grid, i,j);
                res = Math.max(currArea, res);
            }
        }

        return res;
    }

    private int getArea(int[][] grid, int x, int y){
        if(ifOnBoard(x, y, grid.length, grid[0].length) == false) return 0;
        if(grid[x][y] == 2 || grid[x][y] == 0) return 0;

        int res = 0;
        grid[x][y] = 2;
        res += 1;

        for(int[] dir: dirs){
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            res += getArea(grid, nextX, nextY);
        }
        return res;
    }


    private boolean ifOnBoard(int x, int y, int n, int m){
        if(x < 0 || x >= n) return false;
        if(y < 0 || y >= m) return false;
        return true;
    }
}
