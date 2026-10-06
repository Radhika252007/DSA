class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        for(int i = 0;i<nums.length;i++){
            while(!dq.isEmpty() && nums[i] > nums[dq.getLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i >= k && dq.getFirst() <= i - k){
                dq.removeFirst();
            }
            if(i>=k-1){
                res[j++] = nums[dq.getFirst()];
            }
        }
        return res;
    }
}