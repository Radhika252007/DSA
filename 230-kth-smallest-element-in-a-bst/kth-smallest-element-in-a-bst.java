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
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        addValues(root, pq);

        for (int i = 1; i < k; i++) {
            pq.poll();
        }

        return pq.peek();
    }

    private void addValues(TreeNode root, PriorityQueue<Integer> pq) {
        if (root == null) return;

        pq.offer(root.val);

        addValues(root.left, pq);
        addValues(root.right, pq);
    }
}