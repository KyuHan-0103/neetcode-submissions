class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        int[] border = new int[n + 2];

        for(int i = 0; i < n; i++){
            border[i + 1] = nums[i];
        }
        border[0] = 1;
        border[n + 1] = 1;

        for(int l = n; l >= 1; l--){
            for(int r = l; r <= n; r++){
                for(int i = l; i <= r; i++){
                    int coins = border[l - 1] * border[r + 1] * border[i];
                    coins += dp[l][i - 1] + dp[i + 1][r];

                    dp[l][r] = Math.max(coins, dp[l][r]);
                }
            }
        }

        return dp[1][n];
    }
}