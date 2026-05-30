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
        rMapper.put(null, null);
        
        Node cur = head;
        while(cur != null){
            if(!rMapper.containsKey(cur)){
                rMapper.put(cur, new Node(0));
            }
            rMapper.get(cur).val = cur.val;
            
            if(!rMapper.containsKey(cur.next)){
                rMapper.put(cur.next, new Node(0));
            }
            rMapper.get(cur).next = rMapper.get(cur.next);

            if(!rMapper.containsKey(cur.random)){
                rMapper.put(cur.random, new Node(0));
            }
            rMapper.get(cur).random = rMapper.get(cur.random);

            cur = cur.next;
        }
        return rMapper.get(head);
    }
}
