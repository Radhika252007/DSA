class Solution {
    public int[] finalPrices(int[] prices) {
        int[] pay = new int[prices.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i< prices.length;i++){
            while(!st.isEmpty() && prices[i] <= prices[st.peek()]){
                int idx = st.pop();
                pay[idx] = prices[idx] - prices[i]; 
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int idx = st.pop();
            pay[idx] = prices[idx];
        }
        return pay;

    }
}