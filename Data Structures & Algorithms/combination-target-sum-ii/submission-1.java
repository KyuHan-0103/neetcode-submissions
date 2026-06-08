class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<>();
        dfs(0, cur, candidates, target);
        return res;
    }

    private void dfs(int i, List<Integer> cur, int[] candidates, int target){
        if(target == 0){
            res.add(new ArrayList<>(cur));
            return;
        }

        if(i >= candidates.length || target < 0){
            return;
        }
        cur.add(candidates[i]);
        dfs(i + 1, cur, candidates, target - candidates[i]);
        cur.remove(cur.size() - 1);

        while(i + 1 < candidates.length && candidates[i] == candidates[i + 1]){
            i++;
        }
        dfs(i + 1, cur, candidates, target);
    }
}
