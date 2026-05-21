class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> setNums = new HashSet<>();
        for(int n : nums){
            setNums.add(n);
        }

        int longest = 0;
        for(int i = 0; i < nums.length; i++){
            //Check if there is a number to the left
            if(!setNums.contains(nums[i]-1)){
                int length = 1;
                while(setNums.contains(nums[i] + length)){
                    length++;
                }
                if(length > longest){
                    longest = length;
                }
            }
        }

        return longest;
    }
}
