class Solution {
    public int countPairs(int[] nums, int low, int high) {
        Trie t = new Trie();
        int less = 0;
        int more = 0;
        for(int val : nums){
            less += t.countLessThan(val,low);
            more += t.countLessThan(val,high+1);
            t.insert(val);
        }
        return more - less;
    }
}
class Trie{
    static class Node{
        Node[] children;
        int count;
        Node(){
            children = new Node[2];
            count = 0;
        }
    }
    Node root;
    Trie(){
        root = new Node();
    }
    public void insert(int num){
        Node curr = root;
        for(int i = 31;i>=0;i--){
            int bit = (num >> i) & 1;
            if(curr.children[bit] == null){
                curr.children[bit] = new Node();
            }
            curr = curr.children[bit];
            curr.count++;
        }
    }
    public int countLessThan(int num, int limit){
        Node curr = root;
        int ans = 0;
        for(int i = 31;i>=0 && curr != null;i--){
            int numBit = (num >> i) & 1;
            int limitBit = (limit >> i) & 1;
            if(limitBit == 1){
                if(curr.children[numBit] != null){
                    ans += curr.children[numBit].count;
                }
                curr = curr.children[1 - numBit];
            } 
            else{
                curr = curr.children[numBit];
            }
        }
        return ans;
    }

}