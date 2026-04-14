class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();
        int i = 0;
        int count = Integer.MIN_VALUE;
        for(int j = 0; j< nums.length ;j++){
           while(!min.isEmpty() && nums[j] < nums[min.peekLast()] ){
            min.pollLast();
           }
           while(!max.isEmpty() && nums[j] > nums[max.peekLast()]){
            max.pollLast();
           }
           min.offerLast(j);
           max.offerLast(j);
           int diff = nums[max.peekFirst()] - nums[min.peekFirst()];
           while(i < j && diff > limit){
             i = Math.min(max.peekFirst(), min.peekFirst()) + 1;
             while(min.peekFirst() < i) min.pollFirst();
             while(max.peekFirst() < i) max.pollFirst();
             diff = nums[max.peekFirst()] - nums[min.peekFirst()];
           }
           count = Math.max(count,j - i +1);
        } 
        return count;
    }
}