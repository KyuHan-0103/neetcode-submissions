class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        List<Integer> max = new ArrayList<>();
        for(int i = 0; i < k-1; i++){
            max.add(nums[i]);
        }

        int l = 0, r = k - 1;
        while(r < nums.length){
            max.add(nums[r]);
            res[l] = Collections.max(max);
            max.remove(Integer.valueOf(nums[l]));
            l++;
            r++;
        }
        return res;
    }
}
