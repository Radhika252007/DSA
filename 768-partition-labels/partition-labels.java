class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastOccur = new int[26];
        for(int i = 0;i<s.length(); i++){
            char c = s.charAt(i);
            lastOccur[c - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int maxSoFar = 0;
        int l = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            maxSoFar = Math.max(lastOccur[c - 'a'], maxSoFar);
            if(lastOccur[c - 'a'] == i && i == maxSoFar){
                ans.add(i - l + 1);
                l = i + 1;
            }
        }
        return ans;
    }
}