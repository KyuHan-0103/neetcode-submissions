class Solution {
    Set<Integer> visit = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n - 1) return false;;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        if(!dfs(0, adj, -1)){
            return false;
        }

        return visit.size() == n;
    }

    private boolean dfs(int node, List<List<Integer>> adj, int prev){
        if(visit.contains(node)) return false;

        visit.add(node);
        for(int i = 0; i < adj.get(node).size(); i++){
            if(adj.get(node).get(i) == prev){
                continue;
            }
            if(!dfs(adj.get(node).get(i), adj, node)){
                return false;
            }
        }
        return true;
    }
}
