class Solution {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int res = 0;
    Integer[][] cache;
    public int longestIncreasingPath(int[][] matrix) {
        cache = new Integer[matrix.length][matrix[0].length];
        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[0].length; c++){
                if(cache[r][c] == null){
                    dfs(matrix, r, c, 1);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int r, int c, int cnt){
        if(cache[r][c] != null){
            return cache[r][c];
        }
        int max = cnt;
        for(int[] d : directions){
            int nr = r + d[0], nc = c + d[1];

            if(nr >= 0 && nc >= 0 && nr < matrix.length &&
            nc < matrix[0].length && matrix[nr][nc] > matrix[r][c]){
                max = Math.max(max, 1 + dfs(matrix, nr, nc, cnt));
            }
        }

        cache[r][c] = max;
        res = Math.max(res, max);
        return max;
    }
}
