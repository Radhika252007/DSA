class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int units = 0;
        for(int i=0;i<height.length;i++){
            while(!st.isEmpty() && height[st.peek()] < height[i]){
                int val = st.pop();
                if(st.isEmpty()){
                    break;
                }
                int left = st.peek();
                int width = i - left - 1;
                int boundedHeight = Math.min(height[left],height[i]) - height[val];
                units  += width * boundedHeight;
            }
            st.push(i);
        }
        return units;
    }
}