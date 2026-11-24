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
    int max;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        max = root.val;
        height(root);
        return max;
    }
    public int height(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0,height(root.left));
        int right = Math.max(0,height(root.right));
        if(left + right + root.val > max) max = left + right + root.val;
        return root.val + Math.max(left, right); 
    }
}