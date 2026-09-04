class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int c1 = 0;
        int c2 = 0;
        for(int i = 0;i<connections.length;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if(ds.findUPar(u) != ds.findUPar(v)){
                ds.unionBySize(u,v);
                c1++;
            }
            else{
                c2++;
            }
        }
        int components = n - c1;
        int needed = components - 1;
        return (c2 >= needed) ? needed : -1;

    }
}
class DisjointSet{
    List<Integer> parent;
    List<Integer> size;
    DisjointSet(int V){
        parent = new ArrayList<>(V);
        size = new ArrayList<>(V);
        for(int i = 0;i<V;i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findUPar(int u){
        if( u == parent.get(u)) return u;
        int up = findUPar(parent.get(u));
        parent.set(u,up);
        return up;
    }
    public void unionBySize(int u, int v){
        int up_u = findUPar(u);
        int up_v = findUPar(v);
        if(up_u == up_v) return;
        if(size.get(up_u) < size.get(up_v)){
            parent.set(up_u, up_v);
            int u_size = size.get(up_u);
            int v_size = size.get(up_v);
            size.set(up_v,u_size+v_size);
        }
        else{
            parent.set(up_v, up_u);
            int u_size = size.get(up_u);
            int v_size = size.get(up_v);
            size.set(up_u,u_size+v_size);
        }
    }

}