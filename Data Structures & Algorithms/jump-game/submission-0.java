class Solution {
    Boolean[] dp;
    public boolean canJump(int[] nums) {
        dp = new Boolean[nums.length];
        return dfs(nums, 0);
    }

    private boolean dfs(int[] nums, int i){
        if(i == nums.length - 1){
            return dp[i] = true;
        }
        if(dp[i] != null){
            return dp[i];
        }
        for(int j = 1; j <= nums[i]; j++){
            if(dfs(nums, i + j)){
                return dp[i] = true;
            }
        }

        return dp[i] = false;
    }
}
