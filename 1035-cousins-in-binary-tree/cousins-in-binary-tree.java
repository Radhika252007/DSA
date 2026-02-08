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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;

        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return 
            (level(root,xx,0)==level(root,yy,0) && (!isSibling(root,xx,yy)));
        
    }
    public TreeNode findNode(TreeNode root, int x){
        if(root==null) return null;
        if(root.val==x) return root;

        TreeNode n = findNode(root.left,x);
        if(n==null){
            n = findNode(root.right,x);
        }
        return n;
    }

    public int level(TreeNode node, TreeNode x, int level){
        if(node == null) return 0;
        if(node == x) return level;

        int l = level(node.left,x,level+1);
        if(l!=0){
            return l;
        }
        return level(node.right,x,level+1);
    }

    boolean isSibling ( TreeNode node, TreeNode x, TreeNode y){
        if(node==null){
            return false;
        }
        return (
            (node.left == x && node.right ==y) || (node.left == y && node.right ==x) || isSibling(node.left, x, y) || isSibling(node.right,x,y)
        );
    }
}