class Solution {
    public String findDifferentBinaryString(String[] nums) {
       int n = nums[0].length();
       List<String> all = new ArrayList<>();
       generateStrings(n,"",all);
       HashSet<String> set = new HashSet<>();
       for(int i=0;i<nums.length;i++){
        set.add(nums[i]);
       }
       for(int i=0;i<all.size();i++){
        if(!set.contains(all.get(i))){
            return all.get(i);
        }
       }
       return "";
    }
    public void generateStrings(int n, String res, List<String> all){
        if(n==0){
            all.add(res);
            return;
        }
        generateStrings(n-1,res+'0',all);
        generateStrings(n-1,res+'1',all);
    }

}