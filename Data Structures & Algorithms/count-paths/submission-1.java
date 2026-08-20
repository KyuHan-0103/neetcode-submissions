class Solution {
    Integer[][] cache;
    public int uniquePaths(int m, int n) {
        cache = new Integer[m][n];
        return dfs(0, 0, m, n);
    }

    private int dfs(int i, int j, int m, int n){
        if(i == (m - 1) && j == (n - 1)){
            return 1;
        }
        if(i >= m || j >= n) return 0;
        if(cache[i][j] != null) return cache[i][j];
        return cache[i][j] = dfs(i, j + 1, m, n) + dfs(i + 1, j, m, n);
    }
}
