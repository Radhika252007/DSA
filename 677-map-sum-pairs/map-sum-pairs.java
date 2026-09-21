class MapSum {
    Trie t;
    public MapSum() {
        t = new Trie();
    }
    
    public void insert(String key, int val) {
        t.insert(key,val);
    }
    
    public int sum(String prefix) {
        return t.startsWith(prefix);
    }
}
class Trie{
    static class Node{
        Node[] children;
        int sum;
        Node(){
            children = new Node[26];
            sum = 0;
        }
    }
    Node root;
    HashMap<String, Integer> map;
    Trie(){
        root = new Node();
        map = new HashMap<>();
    }
    public void insert(String s, int value){
        Node curr = root;
        if(map.containsKey(s)){
            int prevval = map.get(s);
            for(int i = 0;i<s.length();i++){
                int c = s.charAt(i) - 'a';
                curr = curr.children[c];
                curr.sum = curr.sum - prevval + value;
            }
        }
        else{
        for(int i = 0;i<s.length();i++){
            int c = s.charAt(i) - 'a';
            if(curr.children[c] == null){
                curr.children[c] = new Node();
            }
            curr = curr.children[c];
            curr.sum += value;
            }
        }
        map.put(s,value);
    }
    public int startsWith(String prefix){
        Node curr = root;
        for(int i = 0;i<prefix.length();i++){
            int c = prefix.charAt(i) - 'a';
            if(curr.children[c] == null) return 0;
            curr = curr.children[c];
        }
        return curr.sum;

    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */