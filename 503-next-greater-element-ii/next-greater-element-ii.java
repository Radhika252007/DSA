class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int[] res = new int[arr.length];
        Arrays.fill(res,-1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<arr.length;i++){
            int num = arr[i];
            while (!st.isEmpty() && arr[st.peek()] < num){
               res[st.pop()] = num;
            }
            st.push(i);
        }
        for(int i =0;i< arr.length;i++){
            while (!st.isEmpty() && arr[st.peek()] < arr[i]){
                res[st.pop()] = arr[i];
            }
        }
        return res;
    }
}