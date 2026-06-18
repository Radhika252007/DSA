/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int min;
    int lastVal;
    public int minDiffInBST(TreeNode root) {
        min = Integer.MAX_VALUE;
        lastVal = Integer.MIN_VALUE;
        inorder(root);
        return min;
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(lastVal == Integer.MIN_VALUE){
            lastVal = root.val;
        }
        else{
            int diff = Math.abs(lastVal - root.val);
            min = Math.min(min,diff);
            lastVal = root.val;
        }
        inorder(root.right);
    }
}