class Solution {
    public String longestCommonPrefix(String[] strs) {
    if(strs.length==0){
        return "";
    }
      String common = "";
      
    return commonPrefix(strs,1,strs[0]);
    }
    public String commonPrefix(String[] strs,int index,String first){
        if(index==strs.length){
            return first;
        }
        String next = strs[index];
        int j=0;
        while(j<first.length() && j<next.length() && first.charAt(j)==next.charAt(j)) j++;
        String newPrefix = first.substring(0,j);
        if(newPrefix.isEmpty()) return "";
        return commonPrefix(strs,index+1,newPrefix);

    }
}