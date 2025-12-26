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
    public ListNode removeNodes(ListNode head) {
        if(head==null || head.next==null) return head;
        Stack<Integer> st = new Stack<>();
        ListNode curr = head;
        while(curr!=null){
            while(!st.isEmpty() && st.peek()<curr.val){
                st.pop();
            }
            st.push(curr.val);
            curr = curr.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(!st.isEmpty()){
            ListNode node = new ListNode(st.pop());
            temp.next = node;
            temp = node; 
        }
        ListNode prev = null;
        curr = dummy.next;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
}