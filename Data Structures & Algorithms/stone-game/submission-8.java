public class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int total = 0;
        for(int s : piles){
            total += s;
        }

        Integer[][] dp = new Integer[n][n];

        for(int l = n - 1; l >= 0; l--){
            for(int r = l; r < n; r++){
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
        int aliceScore = dp[0][n - 1];
        return aliceScore > total - aliceScore;
    }
}