class Solution {
   public static int largestRectangleArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int maxSum = 0;
        stack.push(0);
        for(int i=1;i<heights.length;i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                maxSum = getMax(heights,stack,maxSum,i);
            }
            stack.push(i);
        }
        int i = heights.length;
        while(!stack.isEmpty()){
            maxSum = getMax(heights,stack,maxSum,i);
        }
        return maxSum;
    }
    private static int getMax(int[] arr, Stack<Integer> stack,int max, int i){
        int area;
        int popped = stack.pop();
        if(stack.isEmpty()){
            area = arr[popped] * i;
        }
        else {
            area = arr[popped] * (i-1-stack.peek());
        }
        return Math.max(max,area);

    }
}