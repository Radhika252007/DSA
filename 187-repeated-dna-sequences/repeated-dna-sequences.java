class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 10) return new ArrayList<>();
        int mask = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<10;i++){
            mask = (mask << 2) | encode(s.charAt(i));
        }
        map.put(mask,1);
        List<String> ans = new ArrayList<>();
        for(int i = 1;i<=s.length()-10;i++){
            int keepBits = (1 << 20) - 1;
            mask = ((mask << 2) | encode(s.charAt(i+9))) & keepBits;
            map.put(mask, map.getOrDefault(mask,0)+1);
            if(map.get(mask) == 2){
                ans.add(s.substring(i, i+10));
            }
        }
        return ans;
    }
    public int encode(char c){
        if (c == 'A') return 0;
        if (c == 'C') return 1;
        if(c == 'G') return 2;
        return 3;
    }
}