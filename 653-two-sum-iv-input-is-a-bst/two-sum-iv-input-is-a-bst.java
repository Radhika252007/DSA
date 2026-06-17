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
    Set<Integer> set;
    public boolean findTarget(TreeNode root, int k) {
         set = new HashSet<>();
         preorder(root);
         return preorder2(root,k);

         
    }
    public void preorder(TreeNode root){
        if(root == null) return;
        set.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
    public boolean preorder2(TreeNode root, int k){
        if(root == null) return false;;
        if(k - root.val != root.val && set.contains(k - root.val)) return true;
        return preorder2(root.left,k) || preorder2(root.right,k);
    }
    
}