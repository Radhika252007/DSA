class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.distance - y.distance);
        List<List<Pair>> list = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0;i<times.length;i++){
            list.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq.offer(new Pair(k,0));
        dist[k] = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int currN = curr.node;
            int currD = curr.distance;
            if (currD > dist[currN]) {
                continue;
            }
            for(Pair val : list.get(currN)){
                if(currD + val.distance < dist[val.node]){
                    dist[val.node] = currD + val.distance;
                    pq.offer(new Pair(val.node,dist[val.node]));
                }
            }
        }
        int ans = 0;
        for(int i = 1;i<=n;i++){
            int val = dist[i];
            if(val == Integer.MAX_VALUE) return -1;
            ans = Math.max(val,ans);
        }
        return ans;

    }
}
class Pair{
    int node;
    int distance;
    Pair(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}