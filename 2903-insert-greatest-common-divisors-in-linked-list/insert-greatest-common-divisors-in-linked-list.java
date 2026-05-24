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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        while(curr!=null && curr.next!=null){
            int a = curr.val;
            int b = curr.next.val;
            ListNode gcd;
            if(a > b){
            gcd = new ListNode(gcd(a,b));
            }
            else{
            gcd = new ListNode(gcd(b,a));
            }
            ListNode temp = curr.next;
            curr.next = gcd;
            gcd.next = temp;
            curr = temp;
        }
        return head;
    }
    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b,a%b);
    }
}