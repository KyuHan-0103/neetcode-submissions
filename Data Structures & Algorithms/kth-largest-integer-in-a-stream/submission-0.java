class KthLargest {
    PriorityQueue<Integer> maxHeap;

    public KthLargest(int k, int[] nums) {
        this.maxHeap = new PriorityQueue<>();
        maxHeap.add(Integer.MIN_VALUE);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= maxHeap.peek()){
                if(maxHeap.size() >= k) maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if(val > maxHeap.peek()){
            maxHeap.poll();
            maxHeap.add(val);
        }
        return maxHeap.peek();
    }
}
