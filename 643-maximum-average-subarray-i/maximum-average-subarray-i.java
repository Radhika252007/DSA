class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i=0,j=0;
        double sum=0.0,max=Double.NEGATIVE_INFINITY;
        while(j<nums.length){
            sum += nums[j]; 
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                if(sum>max){
                    max = sum;
                }
                sum -= nums[i];
                i++;
                j++;
            }
        }
        return max/k;
    }
}