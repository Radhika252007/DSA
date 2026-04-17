class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] pse = new int[arr.length];
        int[] nse = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        // next smaller element
        for(int i =  arr.length - 1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i] = arr.length;
            }
            else{
                nse[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i = 0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i] = -1;
            }
            else{
                pse[i] = st.peek();
            }
            st.push(i);
        }
        long sum = 0;
        long mod = 1000000007;
        for(int i = 0;i<arr.length;i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            sum = (sum + ((long)arr[i] * left * right) % mod) % mod;
        }
        return (int)sum;

    }
}