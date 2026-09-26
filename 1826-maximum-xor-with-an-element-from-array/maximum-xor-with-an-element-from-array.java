class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int[][] q = new int[queries.length][3];

        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }

        Arrays.sort(q, (a, b) -> a[1] - b[1]);
        Trie t = new Trie();
        int j = 0;
        int[] res = new int[queries.length];
        for(int i = 0;i<q.length;i++){
            int x = q[i][0];
            int m = q[i][1];
            int idx = q[i][2];
            while(j < nums.length && nums[j] <= m){
                t.insert(nums[j]);
                j++;
            }
            if(j == 0){
                res[idx] = -1;
            }
            else{
            res[idx] = t.getMax(x);
            }
        }
        return res;
    }
}
class Trie{
    static class Node{
        Node[] next;
        Node(){
            next = new Node[2];
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
            if(curr.next[bit] == null){
                curr.next[bit] = new Node();
            }
            curr = curr.next[bit];
        }
    }
    public int getMax(int num){
        Node curr = root;
        int max = 0;
        for(int i = 31;i>=0;i--){
            int bit = (num >> i) & 1;
            if(curr.next[1- bit] != null){
                max = max | (1 << i);
                curr = curr.next[1 - bit];
            }
            else{
                curr = curr.next[bit];
            }
        }
        return max;
    }
}