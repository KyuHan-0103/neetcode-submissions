class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int[] temp = new int[prices.length];
        temp[prices.length - 1] = 0;
        for(int i = prices.length - 2; i >= 0; i--){
            if(prices[i + 1] - prices[i] > temp[i + 1]){
                temp[i] = prices[i+1] - prices[i];
                prices[i] = prices[i + 1];
            } else {
                sum += temp[i + 1];
                temp[i] = 0;
            }
        }
        sum += temp[0];
        return sum;

    }
}