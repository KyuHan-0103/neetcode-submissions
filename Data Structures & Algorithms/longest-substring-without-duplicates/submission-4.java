class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        Set<Character> windowCounter = new HashSet<>();
        int l = 0, longest = 0;
        for(int r = 0; r<s.length(); r++){
            while(windowCounter.contains(s.charAt(r))){
                windowCounter.remove(s.charAt(l));
                l++;
            }
            windowCounter.add(s.charAt(r));
            longest = Math.max(longest, (r - l + 1));
        }
        return longest;
    }
}
