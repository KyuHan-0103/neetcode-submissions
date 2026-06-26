class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][] {newInterval};
        }
        
        List<int[]> res = new ArrayList<>();
        for(int[] i : intervals){
            if(newInterval == null || i[1] < newInterval[0]){
                res.add(i);
            } else if(i[0] > newInterval[1]){
                res.add(newInterval);
                res.add(i);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(i[0], newInterval[0]);
                newInterval[1] = Math.max(i[1], newInterval[1]);
            }
        }
        if(newInterval != null){
            res.add(newInterval);
        }
        return res.toArray(new int[0][]);
    }
}
