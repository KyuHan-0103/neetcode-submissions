class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        for(int i = prices.length - 1; i >= 0; i--){
            for(int buying = 1; buying >= 0; buying--){
                if(buying == 1){
                    int buy = dp[i + 1][0] - prices[i];
                    int cd = dp[i + 1][1];
                    dp[i][1] = Math.max(buy, cd);
                } else {
                    int sell = (i + 2 < prices.length) ? dp[i + 2][1] + prices[i] : prices[i];
                    int cd = dp[i + 1][0];
                    dp[i][0] = Math.max(sell, cd);
                }
            }
        }
        return dp[0][1];
    }
}
