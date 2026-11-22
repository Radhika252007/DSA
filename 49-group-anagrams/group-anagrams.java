class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      HashMap<String, List<String>> map = new HashMap<>();
      for(String s : strs){
        char[] curr = s.toCharArray();
        Arrays.sort(curr);
        String c = new String(curr);
        if(!map.containsKey(c)){
            map.put(c, new ArrayList<>());
            map.get(c).add(s);
        }
        else{
            map.get(c).add(s);
        }
      }
        return new ArrayList<>(map.values());
    }
}