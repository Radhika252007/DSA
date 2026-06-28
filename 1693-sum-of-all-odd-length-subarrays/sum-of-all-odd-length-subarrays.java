class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        int sum = arr[0];
        for(int i = 1;i<arr.length;i++){
            prefix[i] = prefix[i-1] + arr[i];
            sum += arr[i];
        }
        int n = arr.length;
        for(int i =2;i<arr.length;i+=2){
            for(int j = 0;j<n-i;j++){
                if(j==0){
                    sum += prefix[i];
                }
                else{
                    sum += (prefix[i+j] - prefix[j-1]);
                }
            }
        }
        return sum;

    }
}