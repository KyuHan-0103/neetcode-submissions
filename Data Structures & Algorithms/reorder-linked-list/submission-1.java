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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode half2 = slow.next;
        ListNode prev = slow.next = null;

        //Reverse 2nd Half
        while(half2 != null){
            ListNode temp = half2.next;
            half2.next = prev;
            prev = half2;
            half2 = temp;
        }

        half2 = prev;
        //Merge two halves
        while(head != null && half2 != null){
            ListNode temp = head.next;
            ListNode temp2 = half2.next;
            head.next = half2;
            half2.next = temp;
            head = temp;
            half2 = temp2;
        }
    }
}
