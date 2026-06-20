class Solution {
    Integer[][] cache;
    public int change(int amount, int[] coins) {
        cache = new Integer[coins.length][amount + 1];
        return dfs(amount, coins, 0, 0);
    }

    private int dfs(int amount, int[] coins, int total, int i){
        if(total > amount || i >= coins.length){
            return 0;
        }
        if(total == amount){
            return 1;
        }
        if(cache[i][total] != null){
            return cache[i][total];
        }
        cache[i][total] = dfs(amount, coins, total + coins[i], i) 
        + dfs(amount, coins, total, i + 1);

        return cache[i][total];
    }
}
