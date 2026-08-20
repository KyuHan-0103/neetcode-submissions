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

class DoublyLinkedNode{
    private Node left, right;
    private int size;

    public DoublyLinkedNode(){
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.size = 0;
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public int length(){
        return this.size;
    }

    public void pushRight(Node n){
        Node prev = this.right.prev;
        prev.next = n;
        n.prev = prev;
        n.next = this.right;
        this.right.prev = n;
        size++;
    }

    public void pop(Node n){
        Node prev = n.prev, next = n.next;
        prev.next = next;
        next.prev = prev;
        n.prev = null;
        n.next = null;
        size--;
    }

    public Node popLeft(){
        Node n = this.left.next;
        pop(n);
        return n;
    }
}

class LFUCache {
    private Map<Integer, Node> nodeMap;
    private Map<Integer, DoublyLinkedNode> linkedMap;
    private int lfuCount;
    private int cap;


    public LFUCache(int capacity) {
        this.cap = capacity;
        this.lfuCount = 0;
        this.nodeMap = new HashMap<>();
        this.linkedMap = new HashMap<>();
 
    }

    private void counter(Node n){
        int cnt = n.count;
        linkedMap.get(cnt).pop(n);

        if(cnt == lfuCount && linkedMap.get(cnt).length() == 0){
            lfuCount++;
        }
        n.count++;
        linkedMap.putIfAbsent(n.count, new DoublyLinkedNode());
        linkedMap.get(n.count).pushRight(n);
    }

    public int get(int key) {
        if(!nodeMap.containsKey(key)){
            return -1;

        }
        counter(nodeMap.get(key));
        return nodeMap.get(key).val;
    }
    
    public void put(int key, int value) {
        if(cap == 0){
            return;
        }
        if(nodeMap.containsKey(key)){
            Node n = nodeMap.get(key);
            counter(n);
            n.val = value;
            return;
        }

        if(nodeMap.size() == cap){
            Node n = linkedMap.get(lfuCount).popLeft();
            nodeMap.remove(n.key);
        }
        Node node = new Node(key, value);
        nodeMap.put(key, node);
        linkedMap.putIfAbsent(1, new DoublyLinkedNode());
        linkedMap.get(1).pushRight(node);
        lfuCount = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */