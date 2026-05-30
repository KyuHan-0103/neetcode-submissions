/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur = l1;
        int excess = 0;
        while(cur != null && l2 != null){
            int val = (cur.val + l2.val) % 10;
            excess += (cur.val + l2.val)/10;
            cur.val = val;
            if(excess > 0){
                if(cur.next != null){
                    int tmp = cur.next.val;
                    cur.next.val = (tmp + excess) % 10;
                    excess = (tmp + excess)/10;
                    System.out.print(excess + ", ");
                } else {
                    cur.next = new ListNode(excess);
                    excess = 0;
                }
            }
            l2 = l2.next;
            cur = cur.next;
        }

        while(cur != null){
            if(excess == 0) break;

            if(cur.next != null){
                int tmp = cur.next.val;
                cur.next.val = (tmp + excess) % 10;
                excess = (tmp + excess)/10;
            } else {
                cur.next = new ListNode(excess);
                break;
            }

            cur = cur.next;
        }

        cur = l1;
        while(l2 != null){
            cur.next = l2;
            if(excess == 0) break;

            int tmp = l2.val;
            l2.val = (tmp + excess) % 10;
            excess = (tmp + excess)/10;

            l2 = l2.next;
        }
        
        if(excess > 0){
            l2 = new ListNode(excess);
        }
        return l1;
    }
}
