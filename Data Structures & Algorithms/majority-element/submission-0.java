class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
            if(map.get(n) >= ((nums.length + 2)/2)) return n;
        }
        return nums[0];
    }
}