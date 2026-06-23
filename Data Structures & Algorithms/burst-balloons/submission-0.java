class Solution {
    Integer[][] cache;
    int[] balloons;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        balloons = new int[n + 2];
        balloons[0] = 1; balloons[n + 1] = 1;          // the buffer 1s at both borders
        for (int i = 0; i < n; i++) balloons[i + 1] = nums[i];
        cache = new Integer[n + 2][n + 2];
        return dfs(0, n + 1);                            // boundaries, exclusive
    }
    private int dfs(int left, int right) {
        if (right - left < 2) return 0;                  // no balloons strictly between
        if (cache[left][right] != null) return cache[left][right];
        int best = 0;
        for (int k = left + 1; k < right; k++) {         // k = last balloon to burst in (left, right)
            int coins = balloons[left] * balloons[k] * balloons[right]
                      + dfs(left, k) + dfs(k, right);
            best = Math.max(best, coins);
        }
        return cache[left][right] = best;
    }
}