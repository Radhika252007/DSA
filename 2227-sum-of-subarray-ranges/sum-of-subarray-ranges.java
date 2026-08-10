class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sumOfMin = 0;
        int[] pse = new int[n];
        int[] nse = new int[n];
        int[] nge = new int[n];
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && nums[i] < nums[st.peek()]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }
        st.clear();
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i] <= nums[st.peek()]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? n - i : st.peek() - i;
            st.push(i);
        }
        for(int i = 0;i<n;i++){
            sumOfMin += (long) nums[i] * pse[i] * nse[i];
        }
        long sumOfMax = 0;
        st.clear();
        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && nums[i] > nums[st.peek()]){
                st.pop();
            }
            pge[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }
        st.clear();
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i] >= nums[st.peek()]){
                st.pop();
            }
            nge[i] = st.isEmpty() ? n - i : st.peek() - i;
            st.push(i);
        }
        for(int i = 0;i<n;i++){
            sumOfMax += (long) nums[i] * pge[i] * nge[i];
        }
        return sumOfMax - sumOfMin;
        
    }
}