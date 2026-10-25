class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       HashMap<Integer, Integer> map = new HashMap<>();
       Stack<Integer> st = new Stack<>();
       int[] res = new int[nums2.length];
       Arrays.fill(res,-1);
       for(int i = 0;i<nums2.length;i++){
            while(!st.isEmpty() && nums2[st.peek()] < nums2[i]){
                int idx = st.pop();
                res[idx] = nums2[i];
            }
            st.push(i);
            map.put(nums2[i],i);
       } 
       int[] ans = new int[nums1.length];
       for(int i = 0;i<nums1.length;i++){
            int val = nums1[i];
            ans[i] = res[map.get(val)]; 
       }
       return ans;
    }
}