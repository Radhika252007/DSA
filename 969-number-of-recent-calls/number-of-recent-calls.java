class RecentCounter {
    int count;
    Queue<Integer> q;
    public RecentCounter() {
        count=0;
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.add(t);
    
            while(!q.isEmpty()){
                if(t - q.peek() <=3000) break;
                q.poll();
            }
            count = q.size();
        return count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */