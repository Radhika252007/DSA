class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Flight>> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0;i<flights.length;i++){
            list.get(flights[i][0]).add(new Flight(flights[i][1],flights[i][2],0));
        }
        int[][] dist = new int[n][k+2];
        for(int[] arr : dist){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        dist[src][0] = 0;
        PriorityQueue<Flight> pq = new PriorityQueue<>((x,y)->x.cost-y.cost);
        pq.offer(new Flight(src,0,0));
        while(!pq.isEmpty()){
            Flight curr = pq.poll();
            int s = curr.stop;
            int currN = curr.node;
            if(currN == dst) return curr.cost;
            if(s == k + 1) continue;
            for(Flight f : list.get(currN)){
                int newCost = curr.cost + f.cost;
                if(newCost < dist[f.node][s+1]){
                    dist[f.node][s + 1] = newCost;
                    pq.offer(new Flight(f.node,newCost,s + 1));
                }
            }
        }
        return -1;

    }
}
class Flight{
    int node;
    int cost;
    int stop;
    Flight(int node, int cost, int stop){
        this.node = node;
        this.cost = cost;
        this.stop = stop;
    }
}