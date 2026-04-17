class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int[] res = new int[arr.length];
        Arrays.fill(res,-1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<arr.length*2;i++){
            int num = arr[i % arr.length];
            while (!st.isEmpty() && arr[st.peek()] < num){
               res[st.pop()] = num;
            }
            if(i<arr.length){
            st.push(i);
            }
        }
        return res;
    }
}