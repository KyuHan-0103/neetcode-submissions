class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<List<Integer>>();
        List<Integer> currentList = new ArrayList<>();
        dfs(0, currentList, target, nums);
        return res;
    }

    private void dfs(int i , List<Integer> list, int target, int[] nums){
        if(target == 0){
            res.add(new ArrayList((list)));
            return;
        }
        if(target < 0 || i >= nums.length){
            return;
        }
    
        list.add(nums[i]);
        dfs(i, list, target - nums[i], nums);
        list.remove(list.size() - 1);
        dfs(i + 1, list, target, nums);
    }
}
