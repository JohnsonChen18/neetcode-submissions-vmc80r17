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
        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        
        // add first
        q.offer(new int[]{x,y});
        grid[x][y] = 2;

        while(q.isEmpty() == false){
            int[] currNode = q.poll();
            res += 1;
            for(int[] dir: dirs){
                int newX = currNode[0] + dir[0];
                int newY = currNode[1] + dir[1];
                if(ifOnBoard(newX, newY, grid.length, grid[0].length) == false) continue;
                if(grid[newX][newY] != 1) continue;
                grid[newX][newY] = 2;
                q.offer(new int[]{newX,newY});
            }
        }
        return res;
    }


    private boolean ifOnBoard(int x, int y, int n, int m){
        if(x < 0 || x >= n) return false;
        if(y < 0 || y >= m) return false;
        return true;
    }
}
