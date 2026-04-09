class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i = 0; i< strs.length;i++){
            String key = func(strs[i]);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> list : map.values()){
            res.add(list);
        }
        return res;
    }
    public String func(String s){
        int[] freq = new int[26];
        for(int i = 0 ;i< s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            sb.append(freq[i]+" ");
        }
        return sb.toString();
    }
}