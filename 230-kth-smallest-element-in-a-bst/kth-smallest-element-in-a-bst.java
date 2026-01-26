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

    public int kthSmallest(TreeNode root, int k) {
       ArrayList<Integer> list = new ArrayList<>();
       getList(root,list);
       return list.get(k-1);
    }
    public void getList(TreeNode root,ArrayList<Integer> list){
        if(root==null) return;
        getList(root.left,list);
        list.add(root.val);
        getList(root.right,list);
    }
}