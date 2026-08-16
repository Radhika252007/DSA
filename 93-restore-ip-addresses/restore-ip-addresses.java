class Solution {
    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        getIpAddress(s,ans,"",0);
        return ans;
    }
    public void getIpAddress(String s, List<String> ans,String curr, int cut){
        if(cut == 4){
            if(s.length() > 0) return;
            ans.add(curr.substring(0, curr.length() - 1));
            return;
        }
        for(int i = 0;i<Math.min(3,s.length());i++){
            String part = s.substring(0,i+1);
            if(part.length() > 1 && part.charAt(0)=='0'){
                continue;
            }
            if(Integer.parseInt(part) > 255) continue;
            getIpAddress(s.substring(i+1),ans,curr+part+'.',cut+1);
        }
    }

}