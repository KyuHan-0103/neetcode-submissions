class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        Set<Character> windowCounter = new HashSet<>();
        int l = 0, r = 1;
        int longest = 1;
        windowCounter.add(s.charAt(0));
        while(r < s.length()){
            if(r==l && r < s.length()-1){
                r++;
            } else if (r==l){
                break;
            }
            if(windowCounter.contains(s.charAt(r))){
                windowCounter.remove(s.charAt(l));
                l++;
                windowCounter.add(s.charAt(l));
            } else {
                longest = Math.max(longest, (r - l + 1));
                windowCounter.add(s.charAt(r));
                r++;
            }
        }
        return longest;
    }
}
