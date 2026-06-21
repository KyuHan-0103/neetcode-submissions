class Solution {
    Map<String, Integer> dp = new HashMap<>();
    public int maxProfit(int[] prices) {
        return dfs(prices, true, 0);
    }

    private int dfs(int[] prices, boolean buying, int i){

        if(i >= prices.length){
            return 0;
        }

        String key = i + "-" + buying;

        if(dp.containsKey(key)){
            return dp.get(key);
        }

        if(buying){
            dp.put(key, Math.max(dfs(prices, false, i + 1) - prices[i], dfs(prices, true, i + 1)));
        } else {
            dp.put(key, Math.max(dfs(prices, true , i + 2) + prices[i], dfs(prices, false, i + 1)));
        }

        return dp.get(key);
    }
}
