class Solution {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int ans = Integer.MAX_VALUE;
        long[] prefix = new long[nums.length+1];
        for(int i = 0;i<nums.length;i++){
            prefix[i+1] = prefix[i] + nums[i];
        }
        for(int i = 0;i<=nums.length;i++){
            while(!dq.isEmpty() && prefix[i] - prefix[dq.getFirst()] >= k){
                ans = Math.min(ans, i - dq.removeFirst());
            }
            while(!dq.isEmpty() && prefix[i] <= prefix[dq.getLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}