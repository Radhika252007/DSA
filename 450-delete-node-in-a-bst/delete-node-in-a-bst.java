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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val == key) {
            if(root.right!=null){
                TreeNode temp = root.right;
                while(temp.left!=null){
                    temp = temp.left;
                }
                temp.left = root.left;
                return root.right;
            }
            return root.left;
        }
        if(key<root.val){
            root.left = deleteNode(root.left,key);
        }
        else{
            root.right = deleteNode(root.right,key);
        }
        return root;

    }
}