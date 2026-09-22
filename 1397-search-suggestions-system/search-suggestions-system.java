class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie t = new Trie();
        Arrays.sort(products);
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
        List<String> products;
        Node(){
            children = new Node[26];
            products = new ArrayList<>();
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
            if(curr.products.size() < 3){
            curr.products.add(word);
            }
        }
    }
    public List<String> getProducts(String s){
        Node curr = root;
        for(int i = 0;i<s.length();i++){
            int c = s.charAt(i) - 'a';
            if(curr.children[c] == null) return new ArrayList<>();
            curr = curr.children[c];
        }
        return curr.products;
    }
    
}