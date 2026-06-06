class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[][] counter = new int[26][2];
        for(char c : tasks){
            counter[c - 'A'][1]++;
        }
        PriorityQueue<int[]> freqHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i = 0; i < counter.length; i++){
            counter[i][0] = i;
            if(counter[i][1] > 0) freqHeap.add(counter[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int cycle = 0;
        while(!freqHeap.isEmpty() || !map.isEmpty()){
            if(map.containsKey(cycle - n - 1)){
                freqHeap.add(counter[map.get(cycle - n - 1)]);
                map.remove(cycle - n - 1);
            }
            if(!freqHeap.isEmpty()){
                int temp = freqHeap.poll()[0];
                counter[temp][1]--;
                if(counter[temp][1] > 0) map.put(cycle, temp);
            }
            cycle++;
        }

        return cycle;
    }
}
