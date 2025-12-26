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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;
        ListNode curr = head;
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                if(curr==null){
                    matrix[top][i] = -1;
                }
                else{
                matrix[top][i] = curr.val;
                curr = curr.next;
                }
            }
            top++;
            for(int i=top;i<=bottom;i++){
                if(curr==null){
                    matrix[i][right] = -1;
                }
                else{
                    matrix[i][right] = curr.val;
                    curr = curr.next;
                }
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    if(curr==null){
                    matrix[bottom][i] = -1;
                }
                else{
                    matrix[bottom][i] = curr.val;
                    curr = curr.next;
                }
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    if(curr==null){
                    matrix[i][left] = -1;
                }
                else{
                    matrix[i][left] = curr.val;
                    curr = curr.next;
                }
                }
                left++;
            }
        }
        return matrix;
    }
}