class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(target, 1);
        for(int total = target; total > 0; total--){
            for(int n : nums){
                if(total < n) break;
                dp.put(total - n, dp.getOrDefault(total, 0) + dp.getOrDefault(total - n, 0));
            }
        }
        return dp.getOrDefault(0, 0);
    }
}