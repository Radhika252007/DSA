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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newl1 = l1;
        ListNode newl2 = l2;
        ListNode result = new ListNode(0);
        ListNode curr = result;
        int carry = 0;
        int value;
        while(newl1!=null || newl2!=null || carry !=0){
            int val1 = (newl1 !=null) ? newl1.val : 0;
            int val2 = (newl2!= null) ? newl2.val : 0;
            int sum = val1+ val2 + carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if(newl1!=null){
            newl1 = newl1.next;
            }
            if(newl2!=null){
            newl2 = newl2.next;
            }
        }

        return result.next;
    }
    
}