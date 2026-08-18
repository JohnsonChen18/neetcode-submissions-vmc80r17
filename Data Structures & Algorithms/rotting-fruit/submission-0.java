class Solution {
    private int[][] dirs = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    // case1: only has fresh ones
    // case2: only has rotted ones
    // case3: has both, all could be rotted
    // case4: has both, not all could be rotted
    public int orangesRotting(int[][] grid) {
        // init and chekc case1 and case2
        int res = -1;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;
        int rottedCount = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) freshCount += 1;
                if(grid[i][j] == 2){
                    rottedCount += 1;
                    q.offer(new int[]{i,j}); 
                }
            }
        }
        if(freshCount == 0) return 0;
        if(rottedCount == 0) return -1;

        // main
        while(q.isEmpty() == false){
            res += 1;
            int size = q.size();

            for(int i = 0; i < size; i++){
                int[] currNode = q.poll();
                for(int[] dir: dirs){
                    int newX = currNode[0] + dir[0];
                    int newY = currNode[1] + dir[1];
                    if(ifOnBoard(grid, newX, newY) == false || grid[newX][newY] != 1) continue;
                    grid[newX][newY] = 2;
                    q.offer(new int[]{newX, newY});
                }
            }
        }

        // check case 4
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) return -1;
            }
        }

        return res;
    }

    private boolean ifOnBoard(int[][] grid, int x, int y){
        if(x < 0 || x >= grid.length) return false;
        if(y < 0 || y >= grid[0].length) return false;
        return true;
    }
}
