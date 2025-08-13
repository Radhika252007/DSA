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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1 || head==null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        while(curr!=null){
            ListNode check = curr;
            int count = 0;
            while (check != null && count < k) {
                check = check.next;
                count++;
            }
            if (count < k) break;
            ListNode last = prev;
            ListNode newEnd = curr;
            for(int i=0;curr!=null && i<k;i++){
                curr.next = prev;
                prev = curr;
                curr = next;
                if(next!=null){
                    next = next.next;
                }
            }
            if(last!=null){
                last.next = prev;
            }
            else{
                head = prev;
            }
            newEnd.next = curr;
            prev = newEnd;

        }
        return head;
}

}
