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
        ListNode prev = null;
        int excess = 0;
        while(cur != null && l2 != null){
            int sum = cur.val + l2.val + excess;
            cur.val = sum % 10;
            excess = sum / 10;
            prev = cur;
            cur = cur.next;
            l2 = l2.next;
        }
        
        if (l2 != null) { prev.next = l2; cur = l2; }

        while (cur != null && excess > 0) {
            int sum = cur.val + excess;
            cur.val = sum % 10;
            excess = sum / 10;
            prev = cur;
            cur = cur.next;
        }

        if (excess > 0) prev.next = new ListNode(excess);

        return l1;
    }
}
