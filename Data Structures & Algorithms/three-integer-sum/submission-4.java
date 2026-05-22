class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triples = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i]==nums[i-1]) continue;

            int l = i + 1, r = nums.length - 1;
            while(l < r){
                         
                if((nums[l] + nums[r])==(-nums[i])){
                    triples.add(new ArrayList<Integer>(
                        Arrays.asList(nums[i], nums[l], nums[r])));
                    r--;
                    l++;
                    while(l < r && nums[l]==nums[l - 1]) l++;

                } else if ((nums[l] + nums[r]) > (-nums[i])){
                    r--;
                } else {
                    l++;
                }
            }
        }
        return triples;
    }
}
