class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> window = new HashMap<>();
        int l = 0, maxF = 0;
        int res = 0;
        for(int r = 0; r < s.length(); r++){
            
            window.put(s.charAt(r), 
            window.getOrDefault(s.charAt(r), 0) + 1);

            maxF = Math.max(maxF, window.get(s.charAt(r)));
            while((r-l + 1)-maxF > k){
              window.put(s.charAt(l),
              window.get(s.charAt(l))-1);
              l++;
            }

            res = Math.max(res, r - l + 1);
        }
        return res;

    }
}
