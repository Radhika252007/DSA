/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int length = 0;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                ListNode temp = slow;
                do{
                    temp = temp.next;
                    length++;
                }
                while(temp!=slow);
                break;
            }
        }
        ListNode first = head;
        ListNode second = head;
        if(length==0){
            return null ;
        }
        while(length>0){
            second = second.next;
            length--;
        }
        while(first!=second){
            first = first.next;
            second = second.next;
        }
        return second;

    }
}