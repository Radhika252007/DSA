class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<chars.length;i++){
            int count = 1;
            char ch = chars[i];
            while(i+1<chars.length && chars[i+1]==ch){
                i++;
                count++;
            }
            sb.append(ch);
            if(count>1){
                sb.append(count);
            }
        }
        char[] res = sb.toString().toCharArray();
        int k = 0;
        for(int i=0;i<res.length;i++){
            chars[i] = res[i];
            k++;
        }
        return k;
    }
}