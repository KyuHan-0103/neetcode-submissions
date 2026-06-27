class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int prev = 0, cur = 1, res = 0;
        while(cur < intervals.length){
            if(intervals[prev][1] > intervals[cur][0]){
                if(intervals[cur][1] > intervals[prev][1]){
                    cur++;
                    res++;
                } else {
                    prev = cur;
                    cur++;
                    res++;
                }
            } else {
                prev = cur;
                cur++;
            }
        }
        return res;
    }
}
