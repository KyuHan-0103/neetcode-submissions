class Solution {
    Boolean[][] cache;
    public boolean isMatch(String s, String p) {
        cache = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(s, p, 0, 0);
    }

    private boolean dfs(String s, String p, int i, int j){
        if(j == p.length() && i == s.length()){
            return cache[i][j] = true;
        }
        if(j == p.length() && i < s.length()) {
            return cache[i][j] = false;
        }
        if(cache[i][j] != null){
            return cache[i][j];
        }
        if(i == s.length() && j + 1 < p.length() && p.charAt(j + 1) == '*'){
            return dfs(s, p, i, j + 2);
        } else if (i == s.length()){
            return cache[i][j] = false;
        }
        if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
            //If we have a match
            if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'){
                return cache[i][j] = dfs(s, p, i + 1, j) || dfs(s, p, i, j + 2);
            } else{
                return cache[i][j] = dfs(s, p, i, j + 2);
            }
        }
        if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'){
            return cache[i][j] = dfs(s, p, i + 1, j + 1);
        }
        return cache[i][j] = false;
    }
}
