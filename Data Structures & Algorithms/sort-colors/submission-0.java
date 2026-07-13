class Solution {
    public void sortColors(int[] nums) {
        int lastZero = 0, lastOne = 0;
        for(int two = 0; two < nums.length; two++){
            int temp = nums[two];
            nums[two] = 2;
            if(temp < 2){
                nums[lastOne++] = 1;
            }
            if(temp < 1){
                nums[lastZero++] = 0;
            }
        }
        
    }
}