class Solution{
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] tmp = prices.clone();
            for (int[] f : flights) {
                int from = f[0], to = f[1], cost = f[2];
                if (prices[from] == Integer.MAX_VALUE) continue;
                if (prices[from] + cost < tmp[to]) tmp[to] = prices[from] + cost;
            }
            prices = tmp;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}