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
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode list : lists){
            if(list != null) pq.offer(list);
        }
        ListNode newHead = null;
        ListNode curr = null;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            if(newHead == null && node != null){
                newHead = node;
                curr = node;
            }
            else{
                curr.next = node;
                curr = node;
            }
            if(node.next != null) pq.offer(node.next);
        }
        return newHead;
    }
}