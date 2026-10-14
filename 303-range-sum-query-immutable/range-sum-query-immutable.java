class NumArray {
    int[] pre;
    public NumArray(int[] nums) {
        pre = new int[nums.length+1];
        pre[0] = 0;
        for(int i = 1;i<pre.length;i++){
            pre[i] = pre[i-1] + nums[i-1];
        }
        System.out.println(Arrays.toString(pre));
    }
    
    public int sumRange(int left, int right) {
        return pre[right+1] - pre[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */