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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode prevSlow = null;
        ListNode prevFirst = null;
        ListNode slow = head;
        for(int i=1;i<k;i++){
            prevFirst = fast;
            fast = fast.next;
        }
        ListNode first = fast;
        while(fast.next!=null){
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if(prevFirst!=null){
            prevFirst.next = slow;
        }
        else{
            head = slow;
        }
        if(prevSlow!=null){
            prevSlow.next = first;
        }
        else{
            head = first;
        }
        ListNode firstNext = first.next;
        first.next = slow.next;
        slow.next = firstNext;
        return head;

    }
}