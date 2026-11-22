class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            String a = convert(count(s));
            if(map.containsKey(a)){
                map.get(a).add(s);
            }
            else{
                map.put(a, new ArrayList<>());
                map.get(a).add(s);
            }
        }
        for(String s : map.keySet()){
            ans.add(map.get(s));
        }
        return ans;
    }
    public String convert(int[] freq){
        String sb = "";
        for(int f : freq){
            sb += f +"#";
        }
        return sb;
    }
    public int[] count(String s){
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        return freq;
    }
}