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
    public ListNode insertionSortList(ListNode head) {
        ListNode curr = head;
        ListNode sorted = null;
        while(curr!=null){
            ListNode next = curr.next;
            if(sorted==null || curr.val<=sorted.val){
                curr.next = sorted;
                sorted = curr;
            }
            else{
                ListNode temp = sorted;
                while(temp.next!=null && temp.next.val < curr.val){
                    temp = temp.next;
                }
                curr.next = temp.next;
                temp.next = curr;
            }
            curr = next;
        }
        return sorted;
    }
}