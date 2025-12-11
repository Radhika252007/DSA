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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        int length = 1;
        ListNode curr = head;
        while(curr.next!=null){
            curr = curr.next;
            length++;
        }
        k = k % length;
        if(k==0) return head;
        ListNode curr2 = head;
        for(int i=1;i<length-k;i++){
            curr2 = curr2.next;
        }
        ListNode newHead = curr2.next;
        curr2.next = null;
        curr.next = head;
        return newHead;
        

    }
}