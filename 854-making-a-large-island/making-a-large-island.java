class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        for(int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] == 1){
                    int[] dr = {1,0,-1,0};
                    int[] dc = {0,1,0,-1};
                    for(int k = 0;k<4;k++){
                        int adjr = i + dr[k];
                        int adjc = j + dc[k];
                        if(adjr < n && adjr >=0 && adjc < n && adjc >=0 && grid[adjr][adjc] == 1){
                            int currNode = i * n + j;
                            int adjNode = adjr * n + adjc;
                            if(ds.UPar(currNode) != ds.UPar(adjNode)){
                                ds.unionBySize(currNode, adjNode);
                            }
                        }
                    }
                }
            }
        }
        int maxIsland = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 0){
                    int[] dr = {1,0,-1,0};
                    int[] dc = {0,1,0,-1};
                    int currI = 1;
                    Set<Integer> seen = new HashSet<>();
                    for(int k = 0;k<4;k++){
                        int adjr = i + dr[k];
                        int adjc = j + dc[k];
                        if(adjr < n && adjr >=0 && adjc < n && adjc >=0 && grid[adjr][adjc] == 1){
                            int currNode = i * n + j;
                            int adjNode = adjr * n + adjc;
                            if(ds.UPar(currNode) != ds.UPar(adjNode)){
                                int parent = ds.UPar(adjNode);
                                if(!seen.contains(parent)){
                                    currI += ds.size.get(parent);
                                    seen.add(parent);
                                }
                            }
                        }
                    }
                    maxIsland = Math.max(maxIsland, currI);
                }
            }
        }
        return maxIsland == 0 ? n*n : maxIsland;
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
    public int UPar(int u){
        if(parent.get(u) == u) return u;
        int up = UPar(parent.get(u));
        parent.set(u,up);
        return up;
    }
    public void unionBySize(int u, int v){
        int up_u = UPar(u);
        int up_v = UPar(v);
        if(up_u == up_v) return;
        if(size.get(up_u) < size.get(up_v)){
            parent.set(up_u, up_v);
            size.set(up_v, size.get(up_u) + size.get(up_v));
        }
        else{
            parent.set(up_v, up_u);
            size.set(up_u, size.get(up_u) + size.get(up_v));
        }
    }
}