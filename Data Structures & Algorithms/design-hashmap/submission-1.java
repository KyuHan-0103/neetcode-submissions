public class MyHashMap {
    private Integer[] map;

    public MyHashMap() {
        map = new Integer[1000001];

    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key] == null ? -1 : map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */