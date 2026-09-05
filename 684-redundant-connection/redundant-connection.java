class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n);
        int[] ans = new int[2];
        for(int i = 0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            if(ds.findUPar(a) != ds.findUPar(b)){
                ds.unionBySize(a,b);
            }
            else{
                ans = edges[i];
            }
        }
        return ans;
    }
}
class DisjointSet{
    List<Integer> parent;
    List<Integer> size;
    DisjointSet(int V){
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for(int i = 0;i <= V;i++){
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