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
    public ListNode[] splitListToParts(ListNode head, int k) {
        if(head==null){
            return new ListNode[k];
        }
        ListNode[] list = new ListNode[k];
        int length = 0;
        ListNode temp = head;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        if(length <= k){
            ListNode curr = head;
            int i =0;
            while(curr!=null){
                ListNode next = curr.next;
                curr.next = null;
                list[i] = curr;
                curr = next;
                i++;
            }
            return list;
        }
        boolean flag = length % k != 0 ? true : false;
        int baseSize;
        if(flag){
            baseSize = (length - (length % k))/ k;
        }
        else{
            baseSize = length / k;
        }
        int extra = length % k;
        ListNode curr = head;
        for(int i=0;i<k;i++){
            list[i] = curr;
            int j = 0;
            if(extra > 0){
                while(j<baseSize && curr !=null){
                    curr = curr.next;
                    j++;
                }
                extra--;
            }
            else{
                while(j<baseSize - 1 && curr !=null){
                    curr = curr.next;
                    j++;
                }
            }
            ListNode next = curr.next;
            curr.next = null;
            curr  = next;
        }
        return list;
           
    }
}
