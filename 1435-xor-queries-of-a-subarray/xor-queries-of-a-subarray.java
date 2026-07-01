class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length + 1];
        prefix[0] = 0;
        for(int i =1;i<prefix.length;i++){
            prefix[i] = prefix[i-1] ^ arr[i-1];
        }
        int[] ans = new int[queries.length];
        for(int i = 0;i<queries.length;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            if(start == end){
                ans[i] = arr[start];
            }
            else{
                ans[i] = prefix[end + 1] ^ prefix[start];
            }
        }
        return ans;


    }
}