class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();

        int res = 0;
        q.offer(0);
        while(!q.isEmpty()){
            res++;
            for(int i = q.size(); i > 0; i--){
                int cur = q.poll();
                for(int s = 1; s * s + cur <= n; s++){
                    int next = cur + s * s;
                    if(next == n) return res;
                    if(!seen.contains(next)){
                        q.offer(next);
                        seen.add(next);
                    }
                }
            }
        }
        return res;
    }
}