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
    public ListNode oddEvenList(ListNode head) {
        ListNode evenHead=null;
        ListNode oddHead=null;
        ListNode ptr1=null;
        ListNode ptr2=null;
        ListNode curr = head;
        int count = 1;
        while(curr!=null){
            if(count%2==1){
                if(oddHead==null){
                    oddHead=curr;
                    ptr1=curr;
                }
                else{
                    ptr1.next = curr;
                    ptr1 = ptr1.next;
                }
            }
            else{
                if(evenHead==null){
                    evenHead = curr;
                    ptr2 = curr;
                }
                else{
                    ptr2.next = curr;
                    ptr2 = ptr2.next;
                }
            }
            curr = curr.next;
            count++;
        }
        if(ptr1!=null){
            ptr1.next = null;
        }
        if(ptr2!=null){
            ptr2.next = null;
        }
        if(oddHead==null){
            return evenHead;
        }
        ptr1.next=evenHead;
        return oddHead;
    }
}