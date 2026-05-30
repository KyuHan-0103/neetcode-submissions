/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Map<Node, Node> rMapper = new HashMap<>();
        Node cur = head;
        while(cur != null){
            Node copy = new Node(cur.val);
            rMapper.put(cur, copy);
            cur = cur.next;
        }

        rMapper.put(null, null);

        Node newNode = rMapper.get(head);
        Node res = newNode;
        while(head != null){
            newNode.random = rMapper.get(head.random);
   
            newNode.next = rMapper.get(head.next);

            head = head.next;
            newNode = newNode.next;
        }
        return res;
    }
}
