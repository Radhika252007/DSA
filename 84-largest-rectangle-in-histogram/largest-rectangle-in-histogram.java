class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int max = 0;
        for(int i=1;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                max = getMax(heights,st,i,max); 
            }
            st.push(i);
        }
        int i = heights.length;
        while(!st.isEmpty()){
        max = getMax(heights,st,i,max);
        }
        return max;
    }
    public int getMax(int[] heights, Stack<Integer> st, int i, int max){
        int popped = st.pop();
        int area = 0;
        if(st.isEmpty()){
            area = heights[popped] * i;
        }
        else{
            area = heights[popped] * (i - st.peek() - 1);
        }
        return Math.max(area,max);
    }
}