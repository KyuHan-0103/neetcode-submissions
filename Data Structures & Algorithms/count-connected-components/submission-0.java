class Solution {
    boolean[] visit;
    public int countComponents(int n, int[][] edges) {
        visit = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                dfs(i, adj);
                res++;
            }
        }
        return res;
    }

    private void dfs(int node, List<List<Integer>> adj){
        visit[node] = true;

        for(int n : adj.get(node)){
            if(!visit[n]){
                dfs(n, adj);
            }
        }
    }
}
