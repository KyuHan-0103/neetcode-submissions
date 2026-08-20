public class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[]{0, 1, 1};
        if(n < 3) return dp[n];
        for (int i = 3; i <= n; i++) {
            int t3 = dp[0] + dp[1] + dp[2];
            int t2 = dp[2];
            dp[0] = dp[1];
            dp[1] = t2;
            dp[2] = t3;
        }
        return dp[2];
    }
}