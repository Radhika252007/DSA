class Solution {
    public int removeStones(int[][] stones) {
        int n  = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for(int i = 0;i<n;i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        Set<Integer> seen = new HashSet<>();
        for(int i = 0;i<n;i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            seen.add(nodeRow);
            seen.add(nodeCol);
        }
        int c = 0;
        for(int node : seen){
            if(ds.findUPar(node) == node) c++;
        }
        return n - c;

    }
}
class DisjointSet{
    List<Integer> parent;
    List<Integer> size;
    DisjointSet(int V){
        parent = new ArrayList<>(V);
        size = new ArrayList<>(V);
        for(int i = 0;i < V;i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findUPar(int u){
        if(parent.get(u) == u) return u;
        int up = findUPar(parent.get(u));
        parent.set(u,up);
        return up;
    }
    public void unionBySize(int u, int v){
        int up_u= findUPar(u);
        int up_v = findUPar(v);
        if(up_u == up_v) return;
        if(size.get(up_u) < size.get(up_v)){
            parent.set(up_u, up_v);
            size.set(up_v, size.get(up_u)+ size.get(up_v));
        }
        else{
            parent.set(up_v, up_u);
            size.set(up_u, size.get(up_u)+ size.get(up_v));
        }
    }
}