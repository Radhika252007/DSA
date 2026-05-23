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
    public ListNode removeZeroSumSublists(ListNode head) {
        int prefix = 0;
        ListNode curr = head;
        HashMap<Integer,ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0);
        map.put(0,dummy);
        dummy.next = head;
        while(curr!=null){
            prefix += curr.val;
            if(map.containsKey(prefix)){
                ListNode start = map.get(prefix);
                ListNode temp = start;
                int sum = prefix;
                while(temp!=curr){
                    temp = temp.next;
                    sum += temp.val;
                    if(temp!=curr){
                        map.remove(sum);
                    }
                }
                start.next = curr.next;
            }
            else{
                map.put(prefix,curr);
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}