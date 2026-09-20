class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }
    public void insert(String word) {
        Node node = root;
        for(int i = 0; i< word.length();i++){
            int c = word.charAt(i) - 'a';
            if(node.children[c] == null){
                node.children[c] = new Node();
            }
            node = node.children[c];
        }
        node.flag = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(int i = 0 ;i< word.length();i++){
            int c = word.charAt(i) - 'a';
            if(curr.children[c] == null) return false;
            curr = curr.children[c];
        }
        return curr.flag;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i = 0; i< prefix.length();i++){
            int c = prefix.charAt(i) - 'a';
            if(curr.children[c] == null) return false;
            curr = curr.children[c];
        }
        return true;
    }
}
class Node{
    Node[] children = new Node[26];;
    boolean flag;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */