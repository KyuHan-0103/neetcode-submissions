class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>());
        return res;
    }

    private void backtrack(int i, int n, int k, List<Integer> combo){
        if(combo.size() == k){
            res.add(new ArrayList<>(combo));
            return;
        }

        for(int j = i; j <= n; j++){
            combo.add(j);
            backtrack(j + 1, n, k, combo);
            combo.remove(combo.size() - 1);
        }
    }
}