class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int ans = Integer.MAX_VALUE;
        int i = startIndex;
        int j =startIndex;
        for(int k = 0; k < words.length; k++){
             if(words[(i) % words.length].equals(target)){
                ans = Math.min(ans,Math.abs(startIndex -i));
             }
             if(words[(j + words.length) % words.length].equals(target)){
                ans = Math.min(ans,Math.abs(startIndex -j));
             }
             i++;
             j--;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}