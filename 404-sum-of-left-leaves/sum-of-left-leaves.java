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
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root,0);
        
    }
    public int dfs(TreeNode root, int flag){
        if(flag==1 && (root.left==null && root.right == null)){
            return root.val;
        }
        int left = 0;
        int right = 0;
        if(root.left!=null){
            left += dfs(root.left,1);
        }
        if(root.right!=null){
            right += dfs(root.right,0);
        }
        return left+right;
    }
}