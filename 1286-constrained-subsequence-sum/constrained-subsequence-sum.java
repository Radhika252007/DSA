class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
       Deque<Integer> dq = new ArrayDeque<>();
       int maxSum = nums[0];
       for(int i = 0;i<nums.length;i++){
            nums[i] += !dq.isEmpty() ? dq.getFirst() : 0;
            maxSum = Math.max(maxSum, nums[i]);
            while(!dq.isEmpty() && nums[i] > dq.getLast()){
                dq.removeLast();
            }
            if(nums[i] > 0){
                dq.addLast(nums[i]);
            }
            if(i >= k && !dq.isEmpty() && dq.getFirst() == nums[i - k]){
                dq.removeFirst();
            }
       } 
       return maxSum;
    }
}