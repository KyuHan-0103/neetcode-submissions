class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int mid = (r + l)/2;
        while(l < r){
            if(nums[mid]==target){
                return mid;
            } else if (nums[mid] < target){
                l = mid + 1;
                mid = (r+l)/2;
            } else {
                r = mid;
                mid = (r+l)/2;
            }
        }
        return (nums[mid]==target) ? mid : -1;
    }
}
