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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        return getPaths(root,0,targetSum) + pathSum(root.left,targetSum) + pathSum(root.right,targetSum);
    }
    public int getPaths(TreeNode node, long currSum, int targetSum){
        if(node == null) return 0;
        currSum += node.val;
        int count = 0;
        if(currSum == targetSum){
            count = 1;
        }
        count += getPaths(node.left,currSum,targetSum);
        count += getPaths(node.right,currSum,targetSum);
        return count;
    }
}