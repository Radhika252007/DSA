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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter-1;
        
    }
    int height(TreeNode node){
        if(node==null){
            return 0;
        }

        int leftheight = height(node.left);
        int rightheight = height(node.right);
        int dia = leftheight + rightheight + 1;
        maxDiameter = Math.max(maxDiameter, dia);
        return Math.max(leftheight, rightheight) + 1;
    }
}