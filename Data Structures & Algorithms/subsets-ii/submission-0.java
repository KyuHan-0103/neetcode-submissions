class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums, cur);

        return res;
    }

    private void dfs(int i, int[] nums, List<Integer> cur){
        if(i >= nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        dfs(i + 1, nums, cur);
        cur.remove(cur.size()-1);

        while(i + 1 < nums.length && nums[i + 1] == nums[i]){
            i++;
        }
        dfs(i + 1, nums, cur);
    }
}
