class Node{
    int val;
    int key;
    int count;
    Node prev;
    Node next;

    public Node(int k, int v){
        this.key = k;
        this.val = v;
        this.prev = null;
        this.next = null;
        this.count = 1;
    }
}

class LFUCache {
    private Map<Integer, Node> map;
    private int cap;
    private Node left;
    private Node right;

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        right.count = Integer.MAX_VALUE;
        left.next = right;
        right.prev = left;
    }
    private void insert(Node n){
        Node temp = this.left.next;
        temp.prev = n;
        this.left.next = n;
        n.prev = this.left;
        n.next = temp;
        countCheck(n);
    }

    private void remove(Node n){
        Node prev = n.prev;
        Node next = n.next;
        prev.next = next;
        next.prev = prev;
        
    }

    private void countCheck(Node n){
        while(n.count >= n.next.count){
            Node next = n.next;
            Node prev = n.prev;
            next.prev = prev;
            prev.next = next;
            n.prev = next;
            n.next = next.next;
            next.next = n;
        }
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            System.out.println(map.get(key).val);
            map.get(key).count++;
            countCheck(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            map.get(key).val = value;
            map.get(key).count++;
        } else {
            if(map.size() == cap){
                Node temp = this.left.next;
                remove(temp);
                map.remove(temp.key);
            }
            Node newN = new Node(key, value);
            map.put(key, newN);
            insert(newN);
        }

        countCheck(map.get(key));
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */