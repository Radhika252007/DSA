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
    public ListNode middleNode(ListNode head) {
        if(head==null){
            return head;
        }
        int count = 0;
        ListNode node = head;
        while(node!=null){
            count++;
            node =node.next;
        }
        int mid = count/2;
        int i= 0;
        ListNode newHead = head;
        while(i!=mid){
            newHead = newHead.next;
            i++;
        }
        return newHead;

    }
}