public class TrieNode{
    TrieNode[] children;
    boolean endOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        endOfWord = false;
    }
}

class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode root){
        TrieNode cur = root;
        for(int i = j; i < word.length(); i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(TrieNode node : cur.children){
                    if(node != null && dfs(word, i + 1, node)){
                        return true;
                    }
                }
                return false;
            } else {
                if(cur.children[c - 'a'] == null){
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
        }
        return cur.endOfWord;
    }
}
