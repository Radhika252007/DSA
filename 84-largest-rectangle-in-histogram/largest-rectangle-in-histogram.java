class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i = 0;i<=heights.length;i++){
            int height = 0;
            if(i < heights.length){
                height = heights[i];
            }
            while(!st.isEmpty() && height < heights[st.peek()]){
                int popped = st.pop();
                int h = heights[popped];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea, h * width);
            }
            st.push(i);
        }
        return maxArea;
    }
}