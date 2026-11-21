class Solution {
    public int maxArea(int[] height) {
        int s = 0;
        int e = height.length - 1;
        int maxArea = 0;
        while(s < e){
            int h = Math.min(height[s], height[e]);
            int w = e - s;
            maxArea = Math.max(maxArea, w * h);
            if(height[s] <= height[e]) s++;
            else e--;
        }
        return maxArea;
    }
}