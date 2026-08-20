class Solution {
    public int minPathSum(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int[] dp = new int[C + 1];
        for(int c = 0; c <= C; c++){
            dp[c] = Integer.MAX_VALUE;
        }
        dp[C - 1] = 0;

        for(int r = R - 1; r >= 0; r--){
            for(int c = C - 1; c >= 0; c--){
                dp[c] = grid[r][c] + Math.min(dp[c], dp[c + 1]);
            }
        }

        return dp[0];
    }
}