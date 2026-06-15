class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> words = new HashSet<>(wordList);
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        set.add(beginWord);
        int len = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                String curr = q.poll();
                if(curr.equals(endWord)) return len;
                char[] arr = curr.toCharArray();
                for (int j = 0;j<curr.length();j++){
                    char original = arr[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        arr[j] = c;
                        String newWord = new String(arr);
                        if(words.contains(newWord) && !set.contains(newWord)){
                            q.offer(newWord);
                            set.add(newWord);
                        }
                    }
                    arr[j] = original;
                }
            }
            len++;
        }
        return 0;
    }
}