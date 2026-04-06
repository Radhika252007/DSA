class RecentCounter {
    int count;
    Queue<Integer> q;
    public RecentCounter() {
        count = 0;
        q = new LinkedList<>();
    }
    
    public int ping(int t) {
        q.add(t);
        while(!q.isEmpty() && t-q.peek() > 3000){
            q.poll();
            count--;
        }
        count++;
        return count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */