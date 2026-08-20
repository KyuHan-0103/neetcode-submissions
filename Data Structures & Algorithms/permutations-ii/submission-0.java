class Solution {
    List<List<Integer>> res;
    boolean[] visit;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        visit = new boolean[nums.length];
        Arrays.sort(nums);
        List<Integer> perm = new ArrayList<>();
        dfs(nums, perm);
        return res;
    }

    private void dfs(int[] nums, List<Integer> perm){
        if(perm.size() == nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visit[i] || (i - 1 >= 0 && nums[i] == nums[i - 1] && !visit[i - 1])){
                continue;
            }
            visit[i] = true;
            perm.add(nums[i]);
            dfs(nums, perm);
            perm.remove(perm.size() - 1);
            visit[i] = false;
        }
    }
}