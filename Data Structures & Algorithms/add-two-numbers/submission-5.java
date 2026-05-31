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
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int excess = 0;
        while(l1 != null || l2 != null || excess > 0){
            int sum = excess;
            if(l1 != null){ sum += l1.val; l1 = l1.next;}
            if(l2 != null){ sum += l2.val; l2 = l2.next;}
            cur.next = new ListNode(sum % 10);
            excess = sum/10;

            cur = cur.next;
        }

        return dummy.next;
    }
}
