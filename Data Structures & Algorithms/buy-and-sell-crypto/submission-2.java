class Solution {
    public int maxProfit(int[] prices) {
        int maxDif = 0;
        int minP = prices[0];
        for(int p : prices){
            maxDif = Math.max(maxDif, p - minP);
            minP = Math.min(minP, p);
        }
        return maxDif;
    }
}
