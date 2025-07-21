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
        while(head!=null){
            if(head.val != val){
                point.next = head;
                point = point.next;
            }
            head = head.next;
        }
        point.next = null;
        return output.next;
    }
}