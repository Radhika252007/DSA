class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie t = new Trie();
        for(int val : nums){
            t.insert(val);
        }
        int max = Integer.MIN_VALUE;
        for(int val : nums){
            max = Math.max(t.getMax(val), max);
        }
        return max;
    }
}
class Trie{
    static class Node{
        Node[] next;
        boolean isEnd;
        Node(){
            next = new Node[2];
            isEnd = false;
        }
    } 
    Node root;
    Trie(){
        root = new Node();
    }
    public void insert(int num){
        Node curr = root;
        for(int i = 31;i>=0;i--){
            int c = (num >> i) & 1;
            if(curr.next[c] == null){
                curr.next[c] = new Node();
            }
            curr = curr.next[c];
        }
        curr.isEnd = true;
    }
    public int getMax(int num){
        Node curr = root;
        int ans = 0;
        for(int i = 31;i>=0;i--){
            int currBit = (num >> i) & 1;
            if(curr.next[1 - currBit] != null){
                ans = ans | (1 << i);
                curr = curr.next[1 - currBit];
            }
            else{
                curr = curr.next[currBit];
            }
        }
        return ans;
    }
}