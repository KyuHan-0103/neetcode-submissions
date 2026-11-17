class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key = lambda x : (x[0], x[1]))
        idx = 0
        res = []
        while idx < len(intervals):
            step = 1
            while idx + step < len(intervals) and intervals[idx][1] >= intervals[idx + step][0]:
                if intervals[idx][1] < intervals[idx + step][1]:
                    intervals[idx][1] = intervals[idx + step][1]
                step += 1
            res.append(intervals[idx])
            idx += step
        return res
