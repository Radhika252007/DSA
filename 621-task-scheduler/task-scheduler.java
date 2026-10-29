class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks){
            freq[task - 'A']++;
        }
        int maxFreq = 0;
        for(int f : freq){
            maxFreq = Math.max(f, maxFreq);
        }
        int c = 0;
        for(int x : freq){
            if(x == maxFreq) c++;
        }
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + c);
       
    }
}
