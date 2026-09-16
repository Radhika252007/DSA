class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int val : asteroids){
            if(val > 0){
                st.push(val);
            }
            else{
                while(!st.isEmpty() && st.peek() > 0 && Math.abs(val) > st.peek()){
                    st.pop();
                }
                if(st.isEmpty() || st.peek() < 0){
                    st.push(val);
                }
                else if(val == -st.peek()){
                    st.pop();
                }
            }
        }
        int[] arr = new int[st.size()];
        int i =0;
        for(int c : st){
            arr[i++] = c;
        }
        return arr;
    }
}