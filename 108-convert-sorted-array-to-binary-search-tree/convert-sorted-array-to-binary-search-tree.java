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
    private TreeNode root;
    public TreeNode sortedArrayToBST(int[] nums) {
        populateTree(nums,0,nums.length-1);
        return root;
    }
    public void populateTree(int[] nums, int start, int end){
        if(start>end) return;
        int mid = start + (end - start)/2;
        insert(nums[mid]);
        populateTree(nums,start,mid-1);
        populateTree(nums,mid+1,end);
    }
    public void insert(int val){
        root = insert(val,root);
    }
    public TreeNode insert(int val, TreeNode node){
        if(node==null){
            node = new TreeNode(val);
            return node;
        }
        if(val<node.val){
            node.left = insert(val,node.left);
        }
        if(val>node.val){
            node.right = insert(val,node.right);
        }
        return node;
    }

}