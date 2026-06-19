class Solution {
    Set<String> visit = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict);
    }

    private boolean dfs(String s, List<String> wordDict){
        if(s.equals("")) return true;
        if(visit.contains(s)){
            return false;
        }

        for(String word : wordDict){
            int index = s.indexOf(word);
            if(index != -1){
                if(dfs(s.substring(0, index), wordDict) && 
                dfs(s.substring(index + word.length()), wordDict)){
                    return true;
                }
            }
        }

        visit.add(s);
        return false;
    }
}
