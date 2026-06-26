class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][] {newInterval};
        }
        int target = newInterval[0], n = intervals.length;
        int l = 0, r = n - 1;

        while(l <= r){
            int mid = (l + r)/2;
            if(intervals[mid][0] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < l; i++){
            res.add(intervals[i]);
        }
        res.add(newInterval);
        for(int i = l; i < n; i++){
            res.add(intervals[i]);
        }

        List<int[]> merged = new ArrayList<>();
        for(int[] i : res){
            if(merged.isEmpty() || 
            merged.get(merged.size() - 1)[1] < i[0]){
                merged.add(i);
            } else {
                merged.get(merged.size() - 1)[1] = 
                Math.max(merged.get(merged.size() - 1)[1], i[1]);
            }
        }

        return merged.toArray(new int[0][]);
    }
}
