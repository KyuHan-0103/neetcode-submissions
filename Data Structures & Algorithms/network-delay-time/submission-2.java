class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for(int[] time : times){
            edges.computeIfAbsent(time[0], 
            key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0]));

        minHeap.offer(new int[]{0, k});
        Set<Integer> visits = new HashSet<>();
        int t = 0;
        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            int w1 = cur[0], n1 = cur[1];
            if(visits.contains(n1)) continue;

            visits.add(n1);
            t = w1;
            
            if(edges.containsKey(n1)){
                for(int[] next : edges.get(n1)){
                    int n2 = next[0], w2 = next[1];
                    if(!visits.contains(n2)){
                        minHeap.offer(new int[]{w1 + w2, n2});
                    }
                }
            }
        }

        return (visits.size() == n) ? t : -1;
    }

}
