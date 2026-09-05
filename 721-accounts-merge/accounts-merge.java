class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> map = new HashMap<>();
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        for(int i = 0;i<n;i++){
            for(int j = 1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(map.containsKey(mail)){
                    ds.unionBySize(map.get(mail),i);
                }
                else{
                    map.put(mail,i);
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(int i = 0;i<n;i++){
            res.add(new ArrayList<>());
        }
        for(String mail : map.keySet()){
            int up = ds.findUPar(map.get(mail));
            res.get(up).add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0;i < n;i++){
            List<String> curr = res.get(i);
            if(curr.size() == 0) continue;
            Collections.sort(curr);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(curr);
            ans.add(temp);
        }
        return ans;

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
        if(parent.get(u) == u) return u;
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
            size.set(up_v, size.get(up_u) + size.get(up_v));
        }
        else{
            parent.set(up_v, up_u);
            size.set(up_u, size.get(up_u) + size.get(up_v));
        }
    }
}