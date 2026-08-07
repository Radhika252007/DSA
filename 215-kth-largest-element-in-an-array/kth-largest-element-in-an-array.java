class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int val : nums){
            pq.offer(val);
        }
        int n = nums.length;
        while(!pq.isEmpty()){
            if(pq.size() == n - k + 1){
                return pq.peek();
            }
            pq.poll();
        }
        return -1;
    }
}