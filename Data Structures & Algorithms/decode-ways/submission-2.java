public class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);
        return dfs(dp, s, 0);
    }

    private int dfs(Map<Integer, Integer> dp, String s, int i){
        if(dp.containsKey(i)){
            return dp.get(i);
        }
        if(s.charAt(i) == '0') return 0;

        int res = dfs(dp, s, i + 1);

        if(i + 1 < s.length() && (s.charAt(i) == '1' 
        || s.charAt(i) == '2' && s.charAt(i + 1) < '7')){
            res += dfs(dp, s, i + 2);
        }

        dp.put(i , res);
        return res;
    }
}