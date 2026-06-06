class Twitter {
    Map<Integer, PriorityQueue<Pair<Integer, Integer>>> tweets;
    Map<Integer, Map<Integer, Integer>> follows;
    int time;
    public Twitter() {
       this.tweets = new HashMap<>();
       this.follows = new HashMap<>();
       this.time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        Pair<Integer, Integer> p = new Pair<Integer, Integer>(time, tweetId);
        if(this.tweets.containsKey(userId)){
            this.tweets.get(userId).add(p);
        } else {
            this.tweets.put(userId, new PriorityQueue<>((a, b) -> b.getKey() - a.getKey()));
            this.tweets.get(userId).add(p);
        }
        this.time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
    PriorityQueue<Pair<Integer, Integer>> feed = 
        new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());

    if(tweets.containsKey(userId)) {
        for (Pair<Integer, Integer> p : tweets.get(userId)) {
            feed.add(p);
        }
    }

    if(follows.containsKey(userId)) {
        for (Map.Entry<Integer, Integer> entry : follows.get(userId).entrySet()) {
            if (tweets.containsKey(entry.getKey()) && entry.getKey() != userId) {
                for (Pair<Integer, Integer> p : tweets.get(entry.getKey())) {
                    feed.add(new Pair<>(p.getKey(), p.getValue()));
                }
            }
        }
    }

    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < 10 && !feed.isEmpty(); i++) {
        res.add(feed.poll().getValue());
    }
    return res;
}
    
    public void follow(int followerId, int followeeId) {
        if(this.follows.containsKey(followerId)){
            this.follows.get(followerId).put(followeeId, time);
        } else {
            this.follows.put(followerId, new HashMap<>(Map.of(followeeId, time)));
        }
        time++;
    }
    
    public void unfollow(int followerId, int followeeId) {
        this.follows.get(followerId).remove(followeeId);
        time++;
    }
}
