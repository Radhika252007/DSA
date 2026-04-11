class Solution {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int ans = Integer.MAX_VALUE;
        long[] prefix = new long[nums.length+1];
        for(int i = 0 ;i< nums.length;i++){
            prefix[i] = (i > 0) ? prefix[i-1] + nums[i] : nums[i];
        }
    
        for(int i = 0 ;i<nums.length;i++){
            if(prefix[i] >= k) ans = Math.min(ans,i+1);
            while(!q.isEmpty() && prefix[i]- prefix[q.getFirst()] >= k){
                ans = Math.min(ans,i-q.removeFirst());
            }
            while(!q.isEmpty() && prefix[i] <= prefix[q.getLast()]){
                q.removeLast();
            }
            q.addLast(i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}