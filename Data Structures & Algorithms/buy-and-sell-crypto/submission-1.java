class Solution {
    public int maxProfit(int[] prices) {
        int maxDif = 0;
        int l = 0, r = 1;
        while(r < prices.length){
            if(prices[r] > prices[l]){
                maxDif = Math.max(maxDif, prices[r]-prices[l]);
            }else{
                l = r;
            }
            r++;
        }
        return maxDif;
    }
}
