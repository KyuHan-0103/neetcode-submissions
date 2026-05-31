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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            ListNode empty = null;
            return empty;
        }
        //if(lists.length == 1) return lists[0];
        for(int i = 1; i < lists.length; i++){
            ListNode l1 = lists[i-1];
            ListNode l2 = lists[i];
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            if(l1 != null){
                cur.next = l1;
            } else {
                cur.next = l2;
            }
            
            lists[i] = dummy.next;
        }

        return lists[lists.length-1];
    }
}
