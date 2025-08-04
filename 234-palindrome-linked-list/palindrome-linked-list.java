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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode headSecond = reverseList(slow);
        ListNode rereverseHead = headSecond;
        while(head!=null && headSecond !=null){
            if(head.val!=headSecond.val){
                break;
            }
            head = head.next;
            headSecond = headSecond.next;

        }
        reverseList(rereverseHead);
        if(head==null || headSecond == null){
            return true;
        }
        return false;

    }
    public ListNode reverseList(ListNode mid){
        ListNode prev = null;
        ListNode pres = mid;
        while(pres!=null){
            ListNode next = pres.next;
            pres.next = prev;
            prev = pres;
            pres = next;
            if(next!=null){
            next = next.next;
            }
        }
        return prev;
    }
}