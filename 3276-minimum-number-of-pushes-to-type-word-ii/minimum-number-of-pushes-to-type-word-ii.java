class Solution {
    public int minimumPushes(String word) {
       HashMap<Character, Integer> map = new HashMap<>();
       for(int i = 0;i<word.length();i++){
        char c = word.charAt(i);
        map.put(c, map.getOrDefault(c,0)+1);
       }
       List<Integer> list = new ArrayList<>(map.values());
       list.sort(Collections.reverseOrder());
       int count = 0;
       for(int i =0;i<list.size();i++){
          count += ((i / 8) + 1) * list.get(i);
       }
       return count;
    }
}