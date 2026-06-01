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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while(head != null){
            int i = 0;
            ListNode prev = null;
            ListNode connection = head;

            ListNode check = head;
            int count = 0;
            while (check != null && count < k) {
                check = check.next;
                count++;
            }
            if (count < k) {
                cur.next = head;
                break;
            }
            
            while(head != null && i < k){
                ListNode temp = head.next;
                head.next = prev;
                prev = head;
                head = temp;
                i++;
            }

            if(i==k){
                cur.next = prev;
                connection.next = head;
                cur = connection;
            }
        }
        return dummy.next;
    }
}
