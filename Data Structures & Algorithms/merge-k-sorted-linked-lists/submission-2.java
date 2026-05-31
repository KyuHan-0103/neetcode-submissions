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
    public ListNode merge(ListNode list1, ListNode list2){
        ListNode l1 = list1;
        ListNode l2 = list2;
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
        
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        while(lists.length > 1){
            List<ListNode> holder = new ArrayList<>();
            for(int i = 0; i < lists.length; i += 2){
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1) < lists.length ? lists[i+1] : null;
                holder.add(merge(l1, l2));
            }
            lists = holder.toArray(new ListNode[0]);
        }

        return lists[0];
    }
}
