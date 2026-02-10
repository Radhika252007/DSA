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
        if(root==null) return res;
         getAllPaths(res,root,new StringBuilder());
        return res;
    }
    public void getAllPaths(List<String> res, TreeNode root, StringBuilder curr){
        if(root==null) return;
        int len = curr.length();
        curr.append(root.val);
        if(root.left==null && root.right==null){
            res.add(curr.toString());
        }
        else{
        curr.append("->");
        getAllPaths(res,root.left,curr);
        getAllPaths(res,root.right,curr);
        }
        curr.setLength(len);
    }
}