class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] first = new int[26];
        Arrays.fill(first,-1);
        int[] last = new int[26];
        Arrays.fill(last,-1);
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(first[c - 'a'] == -1){
                first[c - 'a'] = i;
            }
            last[c - 'a'] = i;   
        }
        List<int[]> intervals = new ArrayList<>();
        for(int i = 0; i< 26;i++){
            if(last[i] == -1) continue;
            int start = first[i];
            int end = last[i];
            boolean valid = true;
            for(int j = start;j<=end;j++){
                int c = s.charAt(j) - 'a';
                if(first[c] < start){
                    valid = false;
                    break;
                }
                end = Math.max(end, last[c]);
            }
            if(valid){
                intervals.add(new int[]{start, end});
            }
        }
        intervals.sort((a,b) -> a[1] - b[1]);
        List<String> ans = new ArrayList<>();
        int prevEnd = -1;
        for(int[] i : intervals){
            if(i[0] > prevEnd){
                ans.add(s.substring(i[0], i[1]+1));
            }
            prevEnd = i[1];
        }
        return ans;


    }
}