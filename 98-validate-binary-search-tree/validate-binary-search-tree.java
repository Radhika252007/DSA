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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValid(root,null , null);
    }
    public boolean isValid(TreeNode root, TreeNode minVal, TreeNode maxVal){
        if(root == null) return true;
        if(minVal != null && root.val <= minVal.val) return false;
        if(maxVal != null && root.val >= maxVal.val) return false;
        return isValid(root.left, minVal, root) && isValid(root.right, root, maxVal);

    }
}