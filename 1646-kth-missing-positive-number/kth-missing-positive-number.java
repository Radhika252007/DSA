class Solution {
    public int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + ( end - start)/2;
            int midVal = arr[mid];
            int currK = midVal - (mid + 1);
            if(currK < k) start = mid + 1;
            else end = mid - 1;
        }
        return end + k + 1;
    }
}