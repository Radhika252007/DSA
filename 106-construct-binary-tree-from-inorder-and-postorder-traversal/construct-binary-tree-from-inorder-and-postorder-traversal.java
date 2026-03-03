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
    int postIdx = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         postIdx = postorder.length - 1;
        TreeNode root = getTree(inorder,postorder,0,inorder.length-1);
        return root;
    }
    public TreeNode getTree(int[] inorder, int[] postorder, int inStart, int inEnd){
        if(inStart>inEnd) return null;
        int r = postorder[postIdx];
        postIdx--;
        int inIdx = 0;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==r){
                inIdx = i;
            }
        }
        TreeNode node = new TreeNode(r);
        node.right = getTree(inorder,postorder,inIdx+1,inEnd);
        node.left = getTree(inorder, postorder,inStart,inIdx-1);
        return node;


    }
}