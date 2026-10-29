class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        dq.addLast(0);
        for(int i = 1;i<nums.length;i++){
            while(!dq.isEmpty() && dq.getFirst() < i - k){
                dq.removeFirst();
            }
            nums[i] += nums[dq.getFirst()];
            while(!dq.isEmpty() && nums[dq.getLast()] <= nums[i]) dq.removeLast();
            dq.addLast(i);
        }
        return nums[n-1];
    }
}