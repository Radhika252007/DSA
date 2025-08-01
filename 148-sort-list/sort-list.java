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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid = middle(head);
        ListNode rightlist= mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightlist);
        return merge(left,right);
    }
    private ListNode middle(ListNode node){
        ListNode fast = node;
        ListNode slow = node;
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        return prev;
    }
    private ListNode merge(ListNode list1 , ListNode list2){
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(list1!=null && list2!=null){
            if(list1.val <=list2.val){
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            }
            else{
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            }
        }
        tail.next = (list1!=null)?list1:list2;
        return dummy.next;
    }

}