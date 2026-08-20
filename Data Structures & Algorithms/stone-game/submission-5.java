public class Solution {
    int[][] dp;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];
        int total = 0;
        for(int s : piles){
            total += s;
        }

        for(int l = n - 1; l >= 0; l--){
            for(int r = l; r <= n - 1; r++){
                boolean even = (r - l + 1) % 2 == 0;
                int left = even ? piles[l] : 0;
                int right = even ? piles[r] : 0;
                if(l == r){
                    dp[l][r] = left;
                } else {
                    dp[l][r] = Math.max(dp[l + 1][r] + left, dp[l][r - 1] + right);
                }
            }
        }
        return dp[0][n - 1] > total - dp[0][n - 1];
    }
}