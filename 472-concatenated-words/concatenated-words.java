class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie t = new Trie();
        for(String word : words){
            t.insert(word);
        }    
        List<String> ans = new ArrayList<>();
        for(String word : words){
            Boolean[] dp = new Boolean[word.length()];
            if(t.canForm(word,0,dp)){
                ans.add(word);
            }
        }
        return ans;
    }
}
class Trie{
    static class Node{
        Node[] children;
        boolean isEnd;
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
        for(char c : word.toCharArray()){
            int v = c - 'a';
            if(curr.children[v] == null){
                curr.children[v] = new Node();
            }
            curr = curr.children[v];
        }
        curr.isEnd = true;
    }
    public boolean canForm(String word, int i, Boolean[] dp){
        if(i == word.length()){
            return true;
        } 
        if(dp[i] != null) return dp[i];
        Node curr = root;
        for(int j = i;j<word.length();j++){
            int c = word.charAt(j) - 'a';
            if(curr.children[c] == null) break;
            curr = curr.children[c];
            if(curr.isEnd){
                if(i == 0 && j == word.length() - 1) continue;
                if(canForm(word, j + 1, dp)){
                    return dp[i] = true;
                }
            }
        }
        return dp[i] = false;
    }
}