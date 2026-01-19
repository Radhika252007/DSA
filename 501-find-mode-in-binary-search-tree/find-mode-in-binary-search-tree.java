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
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        getFrequency(root,map);
        ArrayList<Integer> list = new ArrayList<>();
        int maxFreq = Integer.MIN_VALUE;
        for(int key : map.keySet()){
            if(map.get(key)>maxFreq){
                maxFreq = map.get(key);
            }
        }
        for(int key: map.keySet()){
            if(map.get(key)==maxFreq){
                list.add(key);
            }
        }
        int[] arr = new int[list.size()];
for (int i = 0; i < list.size(); i++) {
    arr[i] = list.get(i);
}
return arr;
        
    }
    public void getFrequency(TreeNode node, HashMap<Integer,Integer> map){
        if(node==null) return;
        map.put(node.val,map.getOrDefault(node.val,0)+1);
        getFrequency(node.left,map);
        getFrequency(node.right,map);
    }
}