class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque();
        int pre = 1;
        int c = 0;
        for(int i = 0;i<n;i++){
            pre *= nums[i];
            q.addLast(nums[i]);
            while(!q.isEmpty() && pre >= k){
                pre/=q.removeFirst();
            }
            c+=q.size();
            
            
        }
        return c;
    }
}