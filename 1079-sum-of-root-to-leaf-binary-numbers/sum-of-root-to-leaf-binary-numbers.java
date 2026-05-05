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
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        findSum(root,0);
        return sum;
    }
    public void findSum(TreeNode root, int curr){
        if(root == null) return;
        if(root.left == null && root.right == null) {
            curr = curr * 2 + root.val;
            sum += curr;
            return;
        }
        curr = curr * 2 + root.val;
        findSum(root.left,curr);
        findSum(root.right,curr);
    }
}