class Solution {
    Integer[][] cache;
    public int minDistance(String word1, String word2) {
        cache = new Integer[word1.length() + 1][word2.length() + 1];
        return dfs(word1, word2, 0, 0);
    }
    private int dfs(String w1, String w2, int i, int j) {
        if (i == w1.length()) return w2.length() - j;
        if (j == w2.length()) return w1.length() - i;
        if (cache[i][j] != null) return cache[i][j];

        if (w1.charAt(i) == w2.charAt(j)) {
            return cache[i][j] = dfs(w1, w2, i + 1, j + 1);
        } else {
            return cache[i][j] = Math.min(dfs(w1, w2, i + 1, j) + 1,
                                 Math.min(dfs(w1, w2, i, j + 1) + 1,
                                          dfs(w1, w2, i + 1, j + 1) + 1));
        }
    }
}