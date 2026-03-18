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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return getTree(nums,0,nums.length-1);
    }
    public TreeNode getTree(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int maxIdx = findmax(nums,start,end);
        TreeNode node = new TreeNode(nums[maxIdx]);
        node.left = getTree(nums,start,maxIdx-1);
        node.right = getTree(nums,maxIdx+1,end);
        return node;
    }
    public int findmax(int[] nums, int start, int end){
        int max = Integer.MIN_VALUE;
        int maxIdx = 0;
        for(int i = start ;i<=end;i++){
            if(nums[i] > max){
                max = nums[i];
                maxIdx = i;
            }

        }
        return maxIdx;
    }
}