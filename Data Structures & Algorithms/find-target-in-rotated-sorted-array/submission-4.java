class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int mid;
        while(l <= r){
            mid = (l + r)/2;
            if(nums[mid]==target) return mid;

            if(target > nums[mid]){
                if(nums[mid] >= nums[l]){
                    l = mid + 1;
                } else if (target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if(nums[mid] >= nums[l]){
                    if(target >= nums[l]){
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
