/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> map = new HashMap<>();
        if(node == null) return null;
        if(node.neighbors.size() == 0) return new Node(node.val);
        return dfs(node,map);
    
    }
    public Node dfs(Node node, HashMap<Node,Node> map){
        List<Node> neighbour = new ArrayList<>();
        Node clone = new Node(node.val);
        map.put(node,clone);
        for(Node it : node.neighbors){
            if(map.containsKey(it)){
                neighbour.add(map.get(it));
            }
            else{
                neighbour.add(dfs(it,map));
            }
        }
        clone.neighbors = neighbour;
        return clone;
    }
}