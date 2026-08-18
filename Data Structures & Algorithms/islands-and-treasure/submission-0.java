class Solution {
    private int[][] dirs = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    private static final int INF = Integer.MAX_VALUE;

    public void islandsAndTreasure(int[][] grid) {
        // init
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] != 0) continue;
                q.offer(new int[]{i,j});
            }
        }

        // main
        while(q.isEmpty() == false){
            int[] currNode = q.poll();
            for(int[] dir: dirs){
                int nextX = currNode[0] + dir[0];
                int nextY = currNode[1] + dir[1];
                if(ifOnBoard(grid, nextX, nextY) == false || grid[nextX][nextY] != INF) continue;
                // update value
                grid[nextX][nextY] = grid[currNode[0]][currNode[1]]+1;
                q.offer(new int[]{nextX, nextY});
            }
        }
    }


    private boolean ifOnBoard(int[][] grid, int x, int y){
        if(x < 0 || x >= grid.length) return false;
        if(y < 0 || y >= grid[0].length) return false;
        return true;
    }
}
