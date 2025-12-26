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
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> index = new Stack<>();
        int length = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            length++;
        }
        int[] arr = new int[length];
        ListNode curr = head;
        for(int i=0;i<length;i++){
            int val = curr.val;
            while(!st.isEmpty() && st.peek()<val){
                arr[index.pop()] = val;
                st.pop();
            }
            st.push(val);
            index.push(i);
            curr = curr.next;
        }
        while(!st.isEmpty()){
            arr[index.pop()] = 0;
            st.pop();
        }
        return arr;
    }
}