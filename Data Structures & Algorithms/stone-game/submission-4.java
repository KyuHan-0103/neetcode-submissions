public class Solution {
    Integer[][] dp;
    public boolean stoneGame(int[] piles) {
        dp = new Integer[piles.length][piles.length];
        int total = 0;
        for(int s : piles){
            total += s;
        }

        int alice = dfs(0, piles.length - 1, piles);
        return alice > total - alice;
    }

    private int dfs(int l, int r, int[]piles){
        if(l > r){
            return 0;
        }
        if(dp[l][r] != null) return dp[l][r];

        boolean even = (r - l + 1) % 2 == 0;
        int left = even ? piles[l] : 0;
        int right = even ? piles[r] : 0;
        return dp[l][r] = Math.max(dfs(l + 1, r, piles) + left, dfs(l, r - 1, piles) + right);
    }
}