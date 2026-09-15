class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(edges.length);
        int[] edge1 = null;
        int[] edge2 = null;
        int secIdx = -1;
        int[] parents = new int[edges.length+1];
        for(int i = 0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(parents[v] == 0){
                parents[v] = u;
            }
            else{
                edge1 = new int[]{u,v};
                edge2 = new int[]{parents[v],v};
                secIdx = i;
            }
        }
        for(int i = 0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(i == secIdx) continue;
            if(ds.findUPar(u) != ds.findUPar(v)){
                ds.unionBySize(u,v);
            }
            else{
                if(edge2 != null) return edge2;
                return new int[]{u,v};
            }
        }
        return edge1;
    }
}
class DisjointSet{
    int[] parent;
    int[] size;
    DisjointSet(int V){
        parent = new int[V + 1];
        size = new int[V + 1];

        for(int i = 1;i<=V;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findUPar(int u){
        if(parent[u] == u) return u;
        int up = findUPar(parent[u]);
        parent[u] = up;
        return up;
    }
    public void unionBySize(int u, int v){
        int up_u = findUPar(u);
        int up_v = findUPar(v);
        if(up_u == up_v) return;
        parent[up_v] = up_u;
        size[up_u] += size[up_v];
    }
}