class Solution {
   
    public List<List<Integer>> permute(int[] nums) {
        return dfs(nums, 0);
    }

    private List<List<Integer>> dfs(int[] nums, int i){
        if(i == nums.length){
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        
        List<List<Integer>> prev = dfs(nums, i + 1);
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> list : prev){
            int cnt = 0;
            while(cnt < list.size()){
                List<Integer> temp = new ArrayList<>(list);
                temp.add(cnt, nums[i]);
                res.add(temp);
                cnt++;
            }
            List<Integer> temp = new ArrayList<>(list);
            temp.add( nums[i]);
            res.add(temp);
        }

        return res;
    }
}
