class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxCount = 0;
        for(int i=0;i<s.length();i++){
        StringBuilder res = new StringBuilder();
            int count = 1;
            for(int j=i+1;j<s.length();j++){
                if (s.charAt(i) != s.charAt(j) && !res.toString().contains(String.valueOf(s.charAt(j)))) {

                    res.append(s.charAt(j));
                    count++;
                }
                else{
                    break;
                }
            }
            maxCount = Math.max(count,maxCount);
        }
        return maxCount;
    }
}