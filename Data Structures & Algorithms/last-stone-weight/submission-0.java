class Solution {
    public int lastStoneWeight(int[] stones) {
        //if x == y remove both
        //else Math.abs(x - y)

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones){
            maxHeap.add(i);
        }
        while(maxHeap.size() > 1){
            int x = maxHeap.poll();
            if(x == maxHeap.peek()){
                maxHeap.poll();
            } else {
                int y = maxHeap.poll();
                maxHeap.add(Math.abs(x - y));
            }
        }
        return (maxHeap.size() == 0) ? 0 : maxHeap.peek();
    }
}
