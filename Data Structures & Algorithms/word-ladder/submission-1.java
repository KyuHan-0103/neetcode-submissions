class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        boolean[] visited = new boolean[wordList.size()];
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int cnt = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int w = 0; w < size; w++){
                String cur = q.poll();
                if(cur.equals(endWord)) return cnt;


                for(int i = 0; i < cur.length(); i++){
                    for(int j = 0; j < wordList.size(); j++){
                        if(visited[j]) continue;
                        String s = wordList.get(j);

                        
                        if(i == 0){
                            if(cur.substring(i + 1).equals(s.substring(i + 1))){
                                visited[j] = true;
                                q.offer(s);
                            }
                        } else if(i == cur.length() - 1){
                            if(cur.substring(0, i).equals(s.substring(0, i))){
                                visited[j] = true;
                                q.offer(s);
                            }
                        } else if (cur.substring(0, i).equals(s.substring(0, i))
                        && cur.substring(i + 1).equals(s.substring(i + 1))){
                            visited[j] = true;
                            q.offer(s);
                        }
                    }
                }
            }
            cnt++;
        }
        
        return 0;
    }

}
