class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        for(int i = n/2-1;i>=0;i--){
            heapify(nums,n,i);
        }
        for(int i = n-1;i>=0;i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            if (i == n - k) {
                return nums[i];
            }
            heapify(nums,i,0);
        }
        return -1;
    }
    public void heapify(int[] array, int n, int i){
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if(left < n && array[left] > array[max]){
            max = left;
        }
        if(right < n && array[right] > array[max]){
            max = right;
        }
        if(max != i){
            int temp = array[max];
            array[max] = array[i];
            array[i] = temp;
            heapify(array,n,max);
        }
    }
}