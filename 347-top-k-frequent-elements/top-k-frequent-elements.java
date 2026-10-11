class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : nums){
            map.put(val, map.getOrDefault(val,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.freq-b.freq);
        int[] res = new int[k];
        for(int val : map.keySet()){
            pq.offer(new Pair(map.get(val), val));
            if(pq.size() > k){
                pq.poll();
            }
        }
        int i  =0;
        while(!pq.isEmpty()){
            res[i++] = pq.poll().val;
        }
        return res;
        
    }
}
class Pair{
    int freq;
    int val;
    Pair(int freq, int val){
        this.freq = freq;
        this.val = val;
    }
}