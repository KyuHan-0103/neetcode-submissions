/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0) return 0;
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals.get(0).end);

        int res = 1;
        for(int i = 1; i < intervals.size(); i++){
            res = Math.max(res, minHeap.size());
            while(!minHeap.isEmpty() && intervals.get(i).start >= minHeap.peek()){
                minHeap.poll();
            }
            minHeap.offer(intervals.get(i).end);
        }
        return res = Math.max(res, minHeap.size());
    }
}
