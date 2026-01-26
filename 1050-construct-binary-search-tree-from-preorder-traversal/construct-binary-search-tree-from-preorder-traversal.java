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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++){
            insertNode(preorder[i],root);
        }
        return root;
    }
    public TreeNode insertNode(int val,TreeNode root){
        if(root==null){
            TreeNode newNode = new TreeNode(val);
            return newNode;
        }
        if(val<root.val){
            root.left = insertNode(val,root.left);
        }
        else{
            root.right = insertNode(val,root.right);
        }
        return root;
    }
}