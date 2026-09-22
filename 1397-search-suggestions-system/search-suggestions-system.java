class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie t = new Trie();
        for(String product : products){
            t.insert(product);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0;i<searchWord.length();i++){
            List<String> curr = t.getProducts(searchWord.substring(0,i+1));
            ans.add(curr);
        }
        return ans;
        
    }
}
class Trie{
    static class Node{
        Node[] children;
        String str;
        Node(){
            children = new Node[26];
            str = null;
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
        curr.str = word;
    }
    public List<String> getProducts(String s){
        Node curr = root;
        for(int i = 0;i<s.length();i++){
            int c = s.charAt(i) - 'a';
            if(curr.children[c] == null) return new ArrayList<>();
            curr = curr.children[c];
        }
        StringBuilder sb = new StringBuilder(s);
        List<String> ans = new ArrayList<>();
        dfs(curr,ans,sb);
        return ans;
    }
    public void dfs(Node root, List<String> ans, StringBuilder sb){
        if(ans.size() == 3) return;
        if(root.str != null){
            ans.add(new StringBuilder(sb).toString());
        }
        for(int i = 0;i<26;i++){
            if(root.children[i] != null){
                dfs(root.children[i],ans,sb.append((char)('a' + i)));
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}