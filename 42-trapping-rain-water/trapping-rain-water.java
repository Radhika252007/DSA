class Solution {
    public int trap(int[] height) {
        int units = 0;
        int l = 0;
        int r =  height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        while(l<r){
            if(height[l]<=height[r]){
                leftMax = Math.max(height[l],leftMax);
                units += leftMax - height[l];
                l++;
            }
            else{
                rightMax = Math.max(height[r],rightMax);
                units += rightMax - height[r];
                r--;
            }
        }
        return units;
       
    }
}