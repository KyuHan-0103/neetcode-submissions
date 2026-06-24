public class Solution {
    public int maxSubArray(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        dp[nums.length - 1][1] = dp[nums.length - 1][0] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            dp[i][1] = Math.max(nums[i], nums[i] + dp[i + 1][1]);

            dp[i][0] = Math.max(dp[i + 1][0], dp[i][1]);
        }
        return dp[0][0];
    }
}