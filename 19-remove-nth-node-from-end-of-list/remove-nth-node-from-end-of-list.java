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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int[] count =  new int[]{0};
        ListNode[] headRef = new ListNode[]{head};
        removeHelper(head,headRef,n,count);
        return headRef[0];
    }
    public ListNode removeHelper(ListNode curr, ListNode[] headRef, int n, int[] count){
        if(curr==null) return null;
        ListNode nextNode = removeHelper(curr.next,headRef, n, count);
        count[0]++;
        if(count[0]==n){
            if(curr==headRef[0]){
                headRef[0] = curr.next;
                return curr.next;
            }
            return curr.next;
        }
        curr.next = nextNode;
        return curr;
    }

}