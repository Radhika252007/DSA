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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        boolean flag = true;
        deque.add(root);
        while(!deque.isEmpty()){
            int levelSize = deque.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                if(flag){
                    TreeNode currNode = deque.removeFirst();
                    currLevel.add(currNode.val);
                    if(currNode.left!=null){
                        deque.addLast(currNode.left);
                    }
                    if(currNode.right!=null){
                        deque.addLast(currNode.right);
                    }
                }
                else{
                    TreeNode currNode = deque.removeLast();
                    currLevel.add(currNode.val);
                    if(currNode.right!=null){
                        deque.addFirst(currNode.right);
                    }
                    if(currNode.left!=null){
                        deque.addFirst(currNode.left);
                    }
                }
            }
            flag = !flag;
            res.add(currLevel);
        }
        return res;
    }
}