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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        ListNode mid = middle(head);
        ListNode hf = head;
        ListNode hs = reverse(mid.next);
        mid.next = null;
        while(hf!=null && hs!=null){
           ListNode temp1 = hf.next;
           ListNode temp2 = hs.next;
           hf.next = hs;
           hs.next = temp1;
           hf = temp1;
           hs = temp2;
        }
    }
    public ListNode middle(ListNode head){
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
