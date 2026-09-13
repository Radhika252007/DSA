class Solution {
    public int nthUglyNumber(int n) {
        int[] primes = {2,3,5};
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();
        int i = 1;
        pq.offer(1L);
        seen.add(1L);
        while(i < n && !pq.isEmpty()){
            long y = pq.poll();
            for(int val : primes){
                long next = y * val;
                if(seen.add(next)){
                pq.offer(y*val);
                }
            }
            i++;
        }
        return pq.peek().intValue();
    }
}