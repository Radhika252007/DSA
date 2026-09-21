class Solution {
    String res;
    public String longestWord(String[] words) {
        res = "";
        Trie t = new Trie();
        for(String word : words){
            t.insert(word);
        }
        dfs(t.root);
        return res;
    }
    public void dfs(Trie.Node node){
        if(node == null) return;
        if(node.isEnd){
            if(node.str.length() > res.length()){
                res = node.str;   
            }
            else if(node.str.length() == res.length() && node.str.compareTo(res) < 0){
                res = node.str;
            }
        }
        for(Trie.Node child : node.children){
            if(child != null && child.str != null){
                dfs(child);
            }
        }
    }
}
class Trie{
    static class Node{
        Node[] children;
        boolean isEnd;
        String str;
        Node(){
            children = new Node[26];
            isEnd = false;
        }
    }
    Node root;
    Trie(){
        root = new Node();
    }
    public void insert(String word){
        Node curr = root;
        for(int i = 0;i<word.length();i++){
            int c = word.charAt(i) - 'a';
            if(curr.children[c] == null){
                curr.children[c] = new Node();
            }
            curr = curr.children[c];
        }
        curr.isEnd = true;
        curr.str = word;
    }
}