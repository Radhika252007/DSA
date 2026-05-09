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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int res = 0;
        while(!q.isEmpty()){
            res = q.peek().val;
            int levelSize = q.size();
            for(int i = 0;i<levelSize;i++){
                TreeNode currNode = q.poll();
                if(currNode.left!=null) q.offer(currNode.left);
                if(currNode.right!=null) q.offer(currNode.right);
            }
           
        }
        return res;
    }
}