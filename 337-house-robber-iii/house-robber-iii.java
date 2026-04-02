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
    HashMap<TreeNode,Integer> map;
    public int rob(TreeNode root) {
        map = new HashMap<>();
        return robHouses(root);
    }
    public int robHouses(TreeNode root){
        if(root == null){
            return 0;
        }
        if(map.containsKey(root)){
            return map.get(root);
        }
        int skip = robHouses(root.left)+ robHouses(root.right);
        int left = 0;
        int right = 0;
        if(root.left!=null){
           left = robHouses(root.left.left) + robHouses(root.left.right);
        }
        if(root.right!=null){
            right = robHouses(root.right.left) + robHouses(root.right.right);
        }
        int take = root.val+left+right;

        int maxVal = Math.max(skip,take);
        map.put(root,maxVal);
        return maxVal;
    }
}