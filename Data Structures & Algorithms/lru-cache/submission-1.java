class LRUCache {

    Map<Integer, Integer> map;
    int cap;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new LinkedHashMap<>(cap, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.cap;
            }
        };
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}
