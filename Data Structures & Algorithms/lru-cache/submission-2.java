class Node {
    
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int k, int v){
        this.key = k;
        this.val = v;
        this.next = null;
        this.prev = null;
    }
}


class LRUCache {

    private int cap;
    private Map<Integer, Node> map;
    private Node left;
    private Node right;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = right;
        this.right.prev = left;
    }

    private void remove(Node n){
        Node prev = n.prev;
        Node next = n.next;
        prev.next = next;
        next.prev = prev;
        
    }

    private void insert(Node n){
        Node temp = this.right.prev;
        temp.next = n;
        this.right.prev = n;
        n.prev = temp;
        n.next = this.right;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            remove(map.get(key));
            insert(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        Node newN = new Node(key, value);
        map.put(key, newN);
        insert(newN);

        if(map.size() > cap){
            Node temp = this.left.next;
            remove(temp);
            map.remove(temp.key);
        }
    }
}
