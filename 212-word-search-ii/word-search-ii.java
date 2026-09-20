class Solution {
    int[][] dir = {
        {1,0}, {0,1}, {-1,0}, {0,-1}
    };
    public List<String> findWords(char[][] board, String[] words) {
        Trie t = new Trie();
        for(String word : words){
            t.insert(word);
        }
        List<String> ans = new ArrayList<>();
        for(int i = 0; i< board.length;i++){
            for(int j = 0; j< board[i].length;j++){
                dfs(board,i,j,t.root,ans);
            }
        }
        return ans;
    }
    public void dfs(char[][] board, int i , int j, Trie.Node node, List<String> ans){
        if(i < 0 || j < 0 || i>= board.length || j >= board[i].length) return;
        char c = board[i][j];
        if(c == '#') return;
        if (node.children[c - 'a'] == null) {
        return;
        }
        node = node.children[c - 'a'];
        if(node.word != null){
            ans.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        for(int k = 0;k< 4;k++){
            int nextR = i + dir[k][0];
            int nextC = j + dir[k][1];
            dfs(board,nextR, nextC, node,ans);
        }
        board[i][j] = c;
    }
   
}

class Trie{
    static class Node{
        Node[] children;
        String word;
        Node(){
            children = new Node[26];
            word =  null;
        }
    }
    Node root;
    Trie(){
        root = new Node();
    }
    public void insert(String word){
        Node curr = root;
        for(int i = 0;i< word.length();i++){
            int c = word.charAt(i) - 'a';
            if(curr.children[c] == null){
                curr.children[c] = new Node();
            }
            curr = curr.children[c];
        }
        curr.word = word;
    }
}