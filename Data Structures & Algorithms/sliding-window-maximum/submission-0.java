class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        List<Integer> max = new ArrayList<>();
        for(int i = 0; i < k; i++){
            max.add(nums[i]);
        }

        int l = 0, r = k - 1;
        while(r < nums.length){
            res[l] = Collections.max(max);
            max.remove(Integer.valueOf(nums[l]));
            l++;
            r++;
            if(r >= nums.length) break;
            max.add(nums[r]);
        }
        return res;
    }
}
