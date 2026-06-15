class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n + 1; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < times.length; i++){
            adj.get(times[i][0]).add(i);
        }

        Queue<int[]> q = new LinkedList<>();
        for(int i : adj.get(k)){
            q.offer(times[i]);
        }

        int time = 0;
        visited.add(k);
        while(!q.isEmpty()){
            System.out.println(visited);
            if(visited.size() == n) break;
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                if(visited.contains(cur[1])) continue;
                if(cur[2] <= time){
                    visited.add(cur[1]);
                    for(int idx : adj.get(cur[1])){
                        q.offer(new int[]{times[idx][0], times[idx][1], times[idx][2] + cur[2]});
                    }
                } else {
                    q.offer(cur);
                }
            }

            time++;
        }

        return (visited.size() == n) ? time-1 : -1;
    }

}
