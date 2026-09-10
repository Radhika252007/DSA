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
    public int averageOfSubtree(TreeNode root) {
        if(root == null) return 0;
        int count = 0;
        int[] res = sum(root,0);
        if(res[0]/res[1] == root.val) count++;
        count+= averageOfSubtree(root.left);
        count+= averageOfSubtree(root.right);
        return count;
    }
    public int[] sum(TreeNode root, int count){
        if(root == null) {
            return new int[]{0,0};
        }
        int sum = root.val;
        int[] left = sum(root.left,count+1);
        int[] right = sum(root.right,count+1);
        return new int[]{sum + left[0] + right[0], 1 + left[1] + right[1]};
        
    }
}
