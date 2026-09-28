class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Trie t = new Trie();
        for(int i = 0;i<words.length;i++){
            t.insert(words[i],i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<words.length;i++){
            t.search(words[i],i,res);
        }
        return res;
    }
}
class Trie{
    static class Node{
        Node[] children;
        int index;
        List<Integer> palindromeList;
        Node(){
            children = new Node[26];
            index = -1;
            palindromeList = new ArrayList<>();
        }
    }
    Node root;
    Trie(){
        root = new Node();
    }
    public void insert(String word, int wordIndex){
        Node curr = root;
        for(int i = word.length()-1;i>=0;i--){
            int c = word.charAt(i) - 'a';
            if(isPal(word,0,i)){
                curr.palindromeList.add(wordIndex);
            }
            if(curr.children[c] == null){
                curr.children[c] = new Node();
            }
            curr = curr.children[c];
        }
        curr.index = wordIndex;
        curr.palindromeList.add(wordIndex);
    }
    public void search(String word,int wordIndex, List<List<Integer>> res){
        Node curr = root;
        for(int i = 0;i<word.length();i++){
            if(curr.index != -1 && curr.index != wordIndex && isPal(word,i,word.length()-1)){
                res.add(Arrays.asList(wordIndex, curr.index));
            }
            int ch = word.charAt(i) - 'a';
            if(curr.children[ch] == null) return;
            curr = curr.children[ch];
        }
        for(int j: curr.palindromeList){
            if(j!= wordIndex){
            res.add(Arrays.asList(wordIndex,j));
            }
        }
    }
    private boolean isPal(String word, int start, int end){
        while(start < end){
            if(word.charAt(start) != word.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    
}