class Solution {
    public int minPathSum(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int[][] dp = new int[R + 1][C + 1];
        dp[R - 1][C - 1] = grid[R - 1][C - 1];
        Arrays.fill(dp[R], Integer.MAX_VALUE);

        for(int r = 0; r < R; r++){
            dp[r][C] = Integer.MAX_VALUE;
        }
        for(int r = R - 1; r >= 0; r--){
            for(int c = C - 1; c >= 0; c--){
                if(r == R - 1 && c == C - 1){
                    continue;
                }
                dp[r][c] = Math.min(dp[r + 1][c], dp[r][c + 1]);
                dp[r][c] += grid[r][c];
            }
        }

        return dp[0][0];
    }
}