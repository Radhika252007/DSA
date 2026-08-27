class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int l = 0;
        int maxCount = 0;
        for(int r = 0;r<s.length();r++){
            char c = s.charAt(r);
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.get(c) > 1){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if(map.get(s.charAt(l)) == 0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            maxCount = Math.max(maxCount,r-l+1);
        }
        return maxCount;
    }
}