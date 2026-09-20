class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(int i = 0 ;i< word.length();i++){
            int c = word.charAt(i) - 'a';
            if(curr.children[c] == null){
                curr.children[c] = new Node();
            }
            curr = curr.children[c];
        }
        curr.flag = true;
    }
    
    public boolean search(String word) {
        return dfs(root,word,0);
    }
    public boolean dfs(Node node, String word, int i){
        if(i == word.length()) return node.flag;
        if(word.charAt(i) == '.'){
            for(Node child : node.children){
                if(child != null && dfs(child, word, i+1)) return true;
            }
            return false;
        }
        int c = word.charAt(i) - 'a';
        if(node.children[c] == null) return false;
        return dfs(node.children[c], word, i+1);
    }
    
}
class Node{
    Node[] children;
    boolean flag;
    Node(){
        children = new Node[26];
        flag = false;
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */