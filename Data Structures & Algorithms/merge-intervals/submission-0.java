class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();

        for(int[] i : intervals){
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
