class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        String hash = "";
        int[] freq = new int[26];
        for(int i = 0;i<p.length();i++){
            freq[p.charAt(i) - 'a']++;
        }
        for(int i = 0;i<26;i++){
            hash += freq[i] + ",";
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<=s.length() - p.length();i++){
            int[] freq2 = new int[26];
            String curr = "";
            for(int j = i;j<i +p.length();j++){
                freq2[s.charAt(j) - 'a']++;
            }
            for(int k = 0;k<26;k++){
                curr += freq2[k] + ",";
            }
            if(curr.equals(hash)) ans.add(i);
        }
        return ans;
    }
}