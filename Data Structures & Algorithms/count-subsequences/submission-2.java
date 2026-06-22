class Solution {
    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length() + 1];
        dp[t.length()] = 1;
        for(int i = s.length()-1; i >= 0; i--){
            int prev = 1;
            for(int j = t.length()-1; j >= 0; j--){
                int res = dp[j];
                if(s.charAt(i) == t.charAt(j)){
                    res += prev;
                }
                prev = dp[j];
                dp[j] = res;
            }
        }

        return dp[0];
    }
}
