class NumMatrix {
    int[][] matrix;
    int[][] sumGrid;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        sumGrid = new int[m][n];

        // init sumGrid
        for(int i = 0; i < m; i++){
            int rowSum = 0;
            for(int j = 0; j < n; j++){
                rowSum += matrix[i][j];
                sumGrid[i][j] = rowSum;
            }
        }
        for(int i = 0; i < n; i++){
            int colSum = 0;
            for(int j = 0; j < m; j++){
                colSum += sumGrid[j][i];
                sumGrid[j][i] = colSum;
            }
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int rightButtomSum = sumGrid[row2][col2];
        int leftTopSum = row1 - 1>=0 && col1-1>=0? sumGrid[row1-1][col1-1]:0;
        int left = col1-1>=0? sumGrid[row2][col1-1]:0;
        int top = row1-1>=0? sumGrid[row1-1][col2]:0;

        return rightButtomSum - left - top + leftTopSum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */