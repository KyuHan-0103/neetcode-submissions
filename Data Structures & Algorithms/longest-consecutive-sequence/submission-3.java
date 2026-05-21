class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Set<Integer>> consecutives = new HashMap<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            /*if(consecutives.containsKey(nums[i]+1)
            && !consecutives.get(nums[i]+1).contains(nums[i])){
                consecutives.get(nums[i+1]).add(nums[i]);
                consecutives.put(nums[i], consecutives.get(nums[i+1]));
            } */
            if(consecutives.containsKey(nums[i]-1)
            && !consecutives.get(nums[i]-1).contains(nums[i])){
                consecutives.get(nums[i-1]).add(nums[i]);
                consecutives.put(nums[i], consecutives.get(nums[i-1]));
            } else {
                consecutives.putIfAbsent(nums[i],
                new HashSet<>(Arrays.asList(nums[i])));
            }
        }

        List<Set<Integer>> sortedLists = new ArrayList<>(consecutives.values());
        sortedLists.sort((a, b) -> b.size() - a.size());
        return (sortedLists.size() != 0) ? sortedLists.get(0).size() : 0;
    }
}
