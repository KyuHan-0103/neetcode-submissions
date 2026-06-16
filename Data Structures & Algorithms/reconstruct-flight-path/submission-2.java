class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> itinerary = new HashMap<>();

        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            itinerary.computeIfAbsent(src, k -> new PriorityQueue<>()).offer(dst);
        }

        List<String> res = new ArrayList<>();
        dfs(itinerary, "JFK", res);

        Collections.reverse(res);
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> itinerary, String depart, List<String> res){
        PriorityQueue<String> q = itinerary.get(depart);
        while(q != null && !q.isEmpty()){
            String dst = q.poll();
            dfs(itinerary, dst, res);
        }
        res.add(depart);
    }
}
