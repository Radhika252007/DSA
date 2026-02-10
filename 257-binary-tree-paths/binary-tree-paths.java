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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        getAllPaths(res,root,"");
        return res;
    }
    public void getAllPaths(List<String> res, TreeNode root, String curr){
        if(root==null) return;
        if(root.left==null && root.right==null){
            curr+= root.val;
            res.add(curr);
            return;
        }
        curr += root.val + "->";
        getAllPaths(res,root.left,curr);
        getAllPaths(res,root.right,curr);
    }
}