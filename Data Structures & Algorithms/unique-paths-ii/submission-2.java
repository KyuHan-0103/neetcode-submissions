class Solution {
    int[][] grid;
    Integer[][] cache;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        grid = obstacleGrid;
        cache = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return dfs(0, 0, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
    }

    private int dfs(int i, int j, int m, int n){
        if(i > m || j > n || grid[i][j] == 1) return 0;
        
        if(i == m && j == n) return 1;

        if(cache[i][j] != null) return cache[i][j];
        return cache[i][j] = dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
    }
}