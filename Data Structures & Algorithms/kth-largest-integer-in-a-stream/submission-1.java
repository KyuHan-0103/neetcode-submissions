class KthLargest {
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        minHeap.add(Integer.MIN_VALUE);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= minHeap.peek()){
                if(minHeap.size() >= k) minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if(val > minHeap.peek()){
            minHeap.poll();
            minHeap.add(val);
        }
        return minHeap.peek();
    }
}
