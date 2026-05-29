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
    public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode reversed = reverseList(head);

    // Edge case: removing the 1st node of the reversed list
    if (n == 1) {
        return reverseList(reversed.next);
    }

    // Walk to the node BEFORE the one we want to remove
    ListNode curr = reversed;
    for (int i = 1; i < n - 1; i++) {
        curr = curr.next;
    }

    // Skip over the target node
    curr.next = curr.next.next;

    return reverseList(reversed);
}
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            
        }
        return prev;
    }
}
