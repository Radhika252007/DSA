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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }
        ListNode output = new ListNode(0);
        ListNode point = output;
        ListNode temp = head;
        while(temp!=null){
            if(temp.val != val){
                point.next = temp;
                point = point.next;
            }
            temp = temp.next;
        }
        point.next = null;
        return output.next;
    }
}