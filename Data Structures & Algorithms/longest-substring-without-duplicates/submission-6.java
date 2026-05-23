class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> windowCounter = new HashMap<>();
        int res = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            if(windowCounter.containsKey(s.charAt(r))){
                l = Math.max(windowCounter.get(s.charAt(r)) + 1, l);
            }
            windowCounter.put(s.charAt(r), r);
            res = Math.max(res, (r - l + 1));

        }
        return res;
    }
}
