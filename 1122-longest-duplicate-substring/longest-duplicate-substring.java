class Solution {

    public String longestDupSubstring(String s) {
        int n = s.length();
        int low = 0;
        int high = n-1;
        int start = -1;
        int maxLen = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            int idx = search(s,mid);
            if(idx!=-1){
                start = idx;
                maxLen = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return start == -1 ? "" : s.substring(start, start + maxLen);
    }
    public int search(String s, int len){
        HashMap<Long, List<Integer>> map = new HashMap<>();
        long mod = (1 << 31) - 1;
        long base = 256;
        long power = 1;
        long hash = 0;
        for(int i = 0;i<len;i++){
            hash = (hash * base + s.charAt(i)) % mod;
            power = (power * base) % mod;
        }
        map.put(hash, new ArrayList<>());
        map.get(hash).add(0);
        for(int i = len;i<s.length();i++){
            hash = (hash * base - s.charAt(i - len) * power % mod + mod) % mod;
            hash = (hash + s.charAt(i)) % mod;
            if(map.containsKey(hash)){
                for(int start : map.get(hash)){
                    if(s.substring(start, start + len).equals(s.substring(i - len + 1, i - len + 1 + len))){
                        return start;
                    }
                }
            }
            map.computeIfAbsent(hash, k -> new ArrayList<>());
            map.get(hash).add(i - len + 1);
        }
        return -1;
    }
}