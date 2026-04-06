class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] answer = new int[temperatures.length];
        for(int i = 0 ; i< temperatures.length;i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                int idx = st.pop();
                answer[idx] = i - idx;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            answer[st.pop()] = 0;
        }
        return answer;
    }
}