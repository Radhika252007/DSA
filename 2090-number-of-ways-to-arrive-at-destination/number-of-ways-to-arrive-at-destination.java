class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = 1000000007;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        List<List<long[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
    adj.add(new ArrayList<>());
}
        for(int i = 0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new long[]{roads[i][1], roads[i][2]});
            adj.get(roads[i][1]).add(new long[]{roads[i][0], roads[i][2]});
        }
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        ways[0] = 1;
        dist[0] = 0;
        pq.offer(new long[]{0,0});
        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            int node = (int)curr[1];
            long currD = curr[0];
            for(long[] adjs : adj.get(node)){
                int adjN = (int)adjs[0];
                long dis = adjs[1];
                if(currD + dis < dist[adjN]){
                    dist[adjN] = currD + dis;
                    pq.offer(new long[]{dist[adjN], adjN});
                    ways[adjN] = ways[node];
                }
                else if(currD + dis == dist[adjN]){
                    ways[adjN] = (ways[adjN] + ways[node]) % mod;
                }
            }
        }
        return ways[n-1];
    }
}