class Solution {

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[] curr = new int[amount + 1];
        curr[0] = 1;
        for(int i = coins.length - 1; i >= 0; i--){
            for(int j = 0; j <= amount; j++){
                if(j - coins[i] >= 0){
                    curr[j] += curr[j - coins[i]];
                }
            }
        }

        return curr[amount];
    }
}
