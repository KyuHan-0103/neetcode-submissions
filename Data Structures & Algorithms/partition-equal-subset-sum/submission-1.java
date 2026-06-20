class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        if(sum % 2 != 0) return false;

        memo = new Boolean[nums.length][sum/2 + 1];

        return dfs(nums, 0, sum/2);
    }

    private boolean dfs(int[] nums, int i, int target){
        if(i >= nums.length){
            return target == 0;
        }
        if(target < 0){
            return false;
        }
        if(memo[i][target] != null){
            return memo[i][target];
        }

        memo[i][target] = dfs(nums, i + 1, target) || 
        dfs(nums, i + 1, target - nums[i]);

        return memo[i][target];
    }
}
