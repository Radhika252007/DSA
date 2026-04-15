class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        for(int k = 0; k < n; k++){
            int next = (startIndex + k) % n;
            int prev = (startIndex - k + n) % n;
             if(words[next].equals(target) || words[prev].equals(target)){
                return k;
             }
        }
        return -1;
    }
}