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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        if(lists.length==1) return lists[0];
        ListNode currList = lists[0];
        for(int i=1;i<lists.length;i++){
            currList = mergeList(currList,lists[i]);
        }
        return currList;
        
    }
    public ListNode mergeList(ListNode list1, ListNode list2){
        if (list1 == null) return list2;
if (list2 == null) return list1;
        ListNode newHead = null;
        ListNode curr = null;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while(temp1!=null && temp2!= null){
            if(temp1.val <= temp2.val){
                if(newHead==null){
                    newHead = temp1;
                    curr = newHead;
                }
                else{
                    curr.next = temp1;
                    curr = curr.next;
                }
                temp1 = temp1.next;
            }
            else{
                if(newHead==null){
                    newHead = temp2;
                    curr = newHead;
                }
                else{
                    curr.next = temp2;
                    curr = curr.next;
                }
                temp2 = temp2.next;
            }
        }
        if (temp1 != null) curr.next = temp1;
        if (temp2 != null) curr.next = temp2;

        return newHead;

    }
}