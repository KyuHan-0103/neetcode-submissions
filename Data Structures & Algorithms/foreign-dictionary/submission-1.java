class Solution {
    public String foreignDictionary(String[] words) {
        Set<Character> letters = new HashSet<>();

        for(String w : words){
            for(int i = 0; i < w.length(); i++){
                letters.add(w.charAt(i));
            }
        }
        Map<Character, Set<Character>> adj = new HashMap<>();
        int[] receiver = new int[26];
        for(int i = 0; i < words.length - 1; i++){
            String a = words[i], b = words[i + 1];
            int j = 0;
            int len = Math.min(a.length(), b.length());

            while(j < len && a.charAt(j) == b.charAt(j)) j++;
            if(j < len){
                char u = a.charAt(j), v = b.charAt(j);
                if(adj.computeIfAbsent(u, key -> new HashSet<>()).add(v)) receiver[v - 'a']++;
            } else if (a.length() > b.length()){
                return "";
            }
        }

        Queue<Character> q = new LinkedList<>();
        for(char c : letters){
            if(receiver[c - 'a'] == 0) q.offer(c);
        }

        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()){
            char c = q.poll();
            res.append(c);
            for(char next : adj.getOrDefault(c, Set.of())){
                if(--receiver[next - 'a'] == 0) q.offer(next);
            }
        }

        return res.length() == letters.size() ? new String(res) : "";
    }
}
