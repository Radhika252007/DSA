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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        path(root,targetSum,list,curr,0);
        return list;
    }
    public void path(TreeNode root, int targetSum,List<List<Integer>> list, List<Integer> curr,int currVal){
        if(root == null) return;
        curr.add(root.val);
        currVal += root.val;
        if(root.left == null && root.right == null && currVal  == targetSum){
            list.add(new ArrayList<>(curr));
        }
        else{
        path(root.left,targetSum,list,curr,currVal);
        path(root.right,targetSum,list,curr,currVal);
        }
        curr.remove(curr.size()-1);
        
    }

}