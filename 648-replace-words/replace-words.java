class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie t = new Trie();
        for(String word : dictionary){
            t.insert(word);
        }
        String[] strs = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            String newStr = t.findPrefix(s);
            if(newStr == null){
                sb.append(s + " ");
            }
            else{
                sb.append(newStr + " ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
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
            str = null;
        }
    }
    Node root;
    Trie(){
        root = new Node();
    }
    public void insert(String word){
        Node curr = root;
        for(int i = 0 ;i<word.length();i++){
            int c = word.charAt(i) - 'a';
            if(curr.children[c] == null){
                curr.children[c] = new Node();
            }
            curr = curr.children[c];
        }
        curr.isEnd = true;
        curr.str = word;
    }
    public String findPrefix(String word){
        Node curr = root;
        for(int i = 0;i<word.length();i++){
            int c = word.charAt(i) - 'a';
            if(curr.children[c] == null) return null;
            curr = curr.children[c];
            if(curr.isEnd) return curr.str;

        }
        return curr.str;
    }

}