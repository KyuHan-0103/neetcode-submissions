class NumMatrix {
    int[][] sumGrid;
    public NumMatrix(int[][] matrix) {
        sumGrid = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 0; i < matrix.length; i++){
            int pre = 0;
            for(int j = 0; j < matrix[0].length; j++){
                pre += matrix[i][j];
                sumGrid[i+1][j+1] = sumGrid[i][j + 1] + pre;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;
        int bottomRight = sumGrid[row2][col2];
        int up = sumGrid[row1 - 1][col2];
        int left = sumGrid[row2][col1 - 1];
        int topLeft = sumGrid[row1 - 1][col1 - 1];
        return bottomRight - up - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */