class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();
        for(int i = 0 ;i < nums.length;i++){
            while(!q.isEmpty() && nums[q.getLast()] <= nums[i]){
                q.removeLast();
            }
            q.addLast(i);
            if(i>=k && q.getFirst() <= i - k){
                q.removeFirst();
            }
            if(i >= k-1){
                arr.add(nums[q.getFirst()]);
            }
        }
        int[] res = new int[arr.size()];
        for(int i = 0 ;i< arr.size();i++){
            res[i] = arr.get(i);
        }
        return res;
    }
    
}